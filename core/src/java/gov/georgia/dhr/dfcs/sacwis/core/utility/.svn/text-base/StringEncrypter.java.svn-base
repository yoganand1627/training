package gov.georgia.dhr.dfcs.sacwis.core.utility;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.KeySpec;

/**
 * This is a string encryption/decryption class that can use the DES or DESede cryptography scheme.  This is used to
 * decrypt the password in architecture.properties that is used in MobileUserSetupConversation.java
 * <pre>
 * Change History:
 * Date     User     Description
 * -------- -------- --------------------------------------
 * 09/21/05 gerryc   SIR 23969 - initial creation
 * </pre>
 *
 * @author Carina Gerry
 */

public class StringEncrypter {

  public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
  public static final String DES_ENCRYPTION_SCHEME = "DES";
  public static final String DEFAULT_ENCRYPTION_KEY = "6565962 This is IMPACT's encryption key  5737192";

  private KeySpec keySpec;
  private SecretKeyFactory keyFactory;
  private Cipher cipher;

  private static final String UNICODE_FORMAT = "UTF8";

  /**
   * Constructor for the string encrypter
   *
   * @param encryptionScheme
   * @throws EncryptionException
   */
  public StringEncrypter(String encryptionScheme) throws EncryptionException {
    this(encryptionScheme, DEFAULT_ENCRYPTION_KEY);
  }

  /**
   * Constructor for the string encrypter
   *
   * @param encryptionScheme
   * @param encryptionKey
   * @throws EncryptionException
   */
  public StringEncrypter(String encryptionScheme, String encryptionKey)
          throws EncryptionException {

    if (encryptionKey == null) {
      throw new IllegalArgumentException("encryption key was null");
    }
    if (encryptionKey.trim().length() < 24) {
      throw new IllegalArgumentException("encryption key was less than 24 characters");
    }
    try {
      byte[] keyAsBytes = encryptionKey.getBytes(UNICODE_FORMAT);

      if (encryptionScheme.equals(DESEDE_ENCRYPTION_SCHEME)) {
        keySpec = new DESedeKeySpec(keyAsBytes);
      } else if (encryptionScheme.equals(DES_ENCRYPTION_SCHEME)) {
        keySpec = new DESKeySpec(keyAsBytes);
      } else {
        throw new IllegalArgumentException("Encryption scheme not supported: "
                                           + encryptionScheme);
      }

      keyFactory = SecretKeyFactory.getInstance(encryptionScheme);
      cipher = Cipher.getInstance(encryptionScheme);

    }
    catch (InvalidKeyException e) {
      throw new EncryptionException(e);
    }
    catch (UnsupportedEncodingException e) {
      throw new EncryptionException(e);
    }
    catch (NoSuchAlgorithmException e) {
      throw new EncryptionException(e);
    }
    catch (NoSuchPaddingException e) {
      throw new EncryptionException(e);
    }

  }

  /**
   * Method that uses a given encryption scheme to encrypt a string
   *
   * @param unencryptedString
   * @return encrypted string
   * @throws EncryptionException
   */
  public String encrypt(String unencryptedString) throws EncryptionException {
    if (unencryptedString == null || unencryptedString.trim().length() == 0) {
      throw new IllegalArgumentException(
              "unencrypted string was null or empty");
    }

    try {
      SecretKey key = keyFactory.generateSecret(keySpec);
      cipher.init(Cipher.ENCRYPT_MODE, key);
      byte[] cleartext = unencryptedString.getBytes(UNICODE_FORMAT);
      byte[] ciphertext = cipher.doFinal(cleartext);

      BASE64Encoder base64encoder = new BASE64Encoder();
      return base64encoder.encode(ciphertext);
    }
    catch (Exception e) {
      throw new EncryptionException(e);
    }
  }

  /**
   * Method that uses the given encryption scheme to decrypt a string
   *
   * @param encryptedString
   * @return decrypted string
   * @throws EncryptionException
   */
  public String decrypt(String encryptedString) throws EncryptionException {
    if (encryptedString == null || encryptedString.trim().length() <= 0) {
      throw new IllegalArgumentException("encrypted string was null or empty");
    }

    try {
      SecretKey key = keyFactory.generateSecret(keySpec);
      cipher.init(Cipher.DECRYPT_MODE, key);
      BASE64Decoder base64decoder = new BASE64Decoder();
      byte[] cleartext = base64decoder.decodeBuffer(encryptedString);
      byte[] ciphertext = cipher.doFinal(cleartext);

      return bytes2String(ciphertext);
    }
    catch (Exception e) {
      throw new EncryptionException(e);
    }
  }

  /**
   * method that converts a byte array and returms a string
   *
   * @param bytes
   * @return converted string
   */
  private static String bytes2String(byte[] bytes) {
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < bytes.length; i++) {
      stringBuffer.append((char) bytes[i]);
    }
    return stringBuffer.toString();
  }

  /**
   * defines a specific encryption exception
   *
   * @author gerryc
   */
  public static class EncryptionException extends Exception {
    public EncryptionException(Throwable t) {
      super(t);
    }
  }
}

 
