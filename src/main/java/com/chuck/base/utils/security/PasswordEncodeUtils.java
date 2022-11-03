package com.chuck.base.utils.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @description
 * @author: Chuck
 * @date: 2/19/2022 11:28 AM
 */
@Slf4j
public class PasswordEncodeUtils {

  private static final String[] hexDigits = {
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"
  };

  private static final String MD5 = "MD5";

  private static final String SHA = "SHA";

  private static Object salt;

  private static String DEFAULT_ALGORITHM = MD5;

  public static String encode(String rawPass, String salt) {
    MessageDigest digest = null;
    try {
      digest = MessageDigest.getInstance(DEFAULT_ALGORITHM);
    } catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
      log.error("加密失败", e);
    }
    return hexString(
        digest.digest(formatPasAndSalt(rawPass, salt).getBytes(StandardCharsets.UTF_8)));
  }

  public static boolean isMatch(String encPass, String rawPass, String salt) {
    return encPass.equals(encode(rawPass, salt));
  }

  /**
   * 获取加密盐
   *
   * @return
   */
  public static String randomSalt() {
    return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
  }

  private static String KEY = "mmc_40003_123456";

  private static String IV = "mmc_40003_123456";

  public static String decrypt(String data) {
    byte[] encrypted1 = new Base64().decode(data);
    try {
      Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
      SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
      IvParameterSpec ivSpec = new IvParameterSpec(IV.getBytes());

      cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
      byte[] original = cipher.doFinal(encrypted1);
      return new String(original).trim();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "";
  }

  //  ==========Private Method==========

  private static String formatPasAndSalt(String password, String salt) {
    return password + "{" + salt + "}";
  }

  private static String hexString(byte[] b) {
    StringBuffer strBuf = new StringBuffer();
    for (int i = 0; i < b.length; i++) {
      strBuf.append(hexString(b[i]));
    }
    return strBuf.toString();
  }

  private static String hexString(byte b) {
    int n = b;
    if (n < 0) {
      n += 256;
    }
    int d1 = n / 16;
    int d2 = n % 6;
    return hexDigits[d1] + hexDigits[d2];
  }
}
