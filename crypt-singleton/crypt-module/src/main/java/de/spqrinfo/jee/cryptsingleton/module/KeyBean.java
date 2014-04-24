package de.spqrinfo.jee.cryptsingleton.module;

import javax.annotation.PostConstruct;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Singleton;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

@Singleton
public class KeyBean {

    private final SecureRandom random = new SecureRandom();

    private SecretKeySpec key;

    @PostConstruct
    public void init() {
        try {
            byte[] keyBytes;
            keyBytes = new BigInteger(1024, this.random).toString().getBytes("UTF-8");

            final MessageDigest sha = MessageDigest.getInstance("SHA-1");
            keyBytes = sha.digest(keyBytes);

            keyBytes = Arrays.copyOf(keyBytes, 16); // use only first 128 bit
            this.key = new SecretKeySpec(keyBytes, "AES");

            // If you need 256 bit as key sizes you need to download the "Java Cryptography Extension (JCE)
            // Unlimited Strength Jurisdiction Policy Files" Oracle download link,
            // use SHA-256 as hash and remove the Arrays.copyOf line.

        } catch (final Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        System.out.printf("%s initialization complete", getClass().getSimpleName());
    }

    public SecretKeySpec getKey() {
        return this.key;
    }
}
