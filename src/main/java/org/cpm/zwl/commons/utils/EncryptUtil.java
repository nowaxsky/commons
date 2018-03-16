package org.cpm.zwl.commons.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

/**
 * encrytor
 * 
 * @author Mailu
 *
 */
public class EncryptUtil {

  /**
   * AES encrypt
   */
  public static String aesEncrypt(String key, String initVector, String value, String model,
      String padding) throws Exception {
    IvParameterSpec ivSpec = new IvParameterSpec(initVector.getBytes("UTF-8"));
    SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

    Cipher cipher = Cipher.getInstance("AES/" + model + "/" + padding);
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

    byte[] encrypted = cipher.doFinal(value.getBytes());

    return DatatypeConverter.printBase64Binary(encrypted);
  }

  /**
   * AES decrypt
   */
  public static String aesDecrypt(String key, String initVector, String encrypted, String model,
      String padding) throws Exception {
    IvParameterSpec ivSpec = new IvParameterSpec(initVector.getBytes("UTF-8"));
    SecretKeySpec keySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

    Cipher cipher = Cipher.getInstance("AES/" + model + "/" + padding);
    cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

    byte[] original = cipher.doFinal(DatatypeConverter.parseBase64Binary(encrypted));

    return new String(original);
  }

  /**
   * MD5 hash
   */
  public static String md5Hash(String value) throws NoSuchAlgorithmException {

    MessageDigest md = MessageDigest.getInstance("MD5");
    md.update(value.getBytes());

    byte[] byteData = md.digest();

    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
      sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }

    return sb.toString();
  }
}
