package de.spqrinfo.jee6.cryptsingleton.module;

import de.spqrinfo.jee6.cryptsingleton.Crypt;

import javax.annotation.PostConstruct;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.xml.bind.DatatypeConverter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Stateless
@Remote(Crypt.class)
public class CryptBean implements Crypt {

    @EJB
    private KeyBean keyBean;

    private SecretKeySpec key;

    public CryptBean() {
        // Production ctor
    }

    CryptBean(KeyBean keyBean) {
        // Test ctor
        this.keyBean = keyBean;
    }

    @PostConstruct
    public void init() {
        this.key = this.keyBean.getKey();
        try {

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private Cipher getCipher() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        return Cipher.getInstance("AES/ECB/PKCS5Padding");
    }

    private String padRight(String s, int n) {
        return String.format("%1$-" + n + "s", s);
    }

    @Override
    public String encrypt(final String plainTextInput) {
        final String plainText = plainTextInput.length() >= 16 ? plainTextInput : padRight(plainTextInput, 16);
        try {
            byte[] input = plainText.getBytes();
            byte[] cipherText = new byte[2 * input.length];

            Cipher cipher = getCipher();
            cipher.init(Cipher.ENCRYPT_MODE, key);

            int contentLength = cipher.update(input, 0, input.length, cipherText, 0);
            contentLength += cipher.doFinal(cipherText, contentLength);

            byte[] minimalCipher = new byte[contentLength];
            System.arraycopy(cipherText, 0, minimalCipher, 0, contentLength);

            return DatatypeConverter.printBase64Binary(minimalCipher);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decrypt(final String cipherText) {
        final byte[] cipherTextBytes = DatatypeConverter.parseBase64Binary(cipherText);
        int ctLength = cipherTextBytes.length;
        try {
            byte[] plainText = new byte[ctLength];

            Cipher cipher = getCipher();
            cipher.init(Cipher.DECRYPT_MODE, key);

            int plainTextLength = cipher.update(cipherTextBytes, 0, ctLength, plainText, 0);
            plainTextLength += cipher.doFinal(plainText, plainTextLength);

            // We need to trim the result string because of padding
            return new String(plainText, 0, plainTextLength).trim();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
