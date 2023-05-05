package com.chuck.base.algorithms.substringmatch;

/** 暴力破解/朴素匹配算法 */
public class BruteForce {

  public static boolean bf(String str, String match) {
    int n = str.length();
    int m = match.length();
    for (int i = 0; i < n - m; i++) {
      for (int j = 0; j < m; j++) {
        if (str.charAt(i + j) != match.charAt(j)) {
          break;
        }
        if (j == m - 1) {
          return true;
        }
      }
    }
    return false;
  }
}
