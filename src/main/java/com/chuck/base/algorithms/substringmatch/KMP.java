package com.chuck.base.algorithms.substringmatch;

/**
 * 部分匹配值：前缀和后缀的最长的共有元素长度
 *
 * <p>以"ABCDABD"为例，
 *
 * <p>　　－　"A"的前缀和后缀都为空集，共有元素的长度为0；
 *
 * <p>　　－　"AB"的前缀为[A]，后缀为[B]，共有元素的长度为0；
 *
 * <p>　　－　"ABC"的前缀为[A, AB]，后缀为[BC, C]，共有元素的长度0；
 *
 * <p>　　－　"ABCD"的前缀为[A, AB, ABC]，后缀为[BCD, CD, D]，共有元素的长度为0；
 *
 * <p>　　－　"ABCDA"的前缀为[A, AB, ABC, ABCD]，后缀为[BCDA, CDA, DA, A]，共有元素为"A"，长度为1；
 *
 * <p>　　－　"ABCDAB"的前缀为[A, AB, ABC, ABCD, ABCDA]，后缀为[BCDAB, CDAB, DAB, AB, B]，共有元素为"AB"，长度为2；
 *
 * <p>　　－　"ABCDABD"的前缀为[A, AB, ABC, ABCD, ABCDA, ABCDAB]，后缀为[BCDABD, CDABD, DABD, ABD, BD,
 * D]，共有元素的长度为0。
 *
 * <p>所以ABCDABD的部分匹配值就是数组[0,0,0,0,1,2,0]。当某位置不匹配时，向后移动的位数=已匹配的字符数-对应的部分匹配值
 */
public class KMP {
  public static boolean kmp(String str, String match) {
    int n = str.length();
    int m = match.length();
    int[] next = next(match);
    for (int i = 0; i < n - m; i++) {
      for (int j = 0; j < m; j++) {
        if (str.charAt(i + j) != match.charAt(j)) {
          j = next[j];
        }
        if (j == m - 1) {
          return true;
        }
      }
    }
    return false;
  }

  private static int[] next(String match) {
    int[] nextArr = new int[match.length()];

    return nextArr;
  }
}
