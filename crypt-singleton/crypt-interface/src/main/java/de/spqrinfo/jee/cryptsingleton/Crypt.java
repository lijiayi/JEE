package de.spqrinfo.jee.cryptsingleton;

public interface Crypt {

    /**
     * Encrypts a given string with a server side generated key.
     * @param plainText string to encrypt
     * @return base64 encoded cipher text
     */
    String encrypt(final String plainText);

    /**
     * Decrypts a given string with a server side generated geky.
     * @param cipherText base64 encoded cipher to decrypt
     * @return plain text string
     */
    String decrypt(final String cipherText);
}
