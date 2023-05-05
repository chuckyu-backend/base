package com.chuck.base.algorithms.sort;

/** 低位优先的字符串数组排序 */
public class LSD {

  public static void sort(String[] a, int w) {
    int r = 256; // 字符集大小
    int n = a.length;
    String[] aux = new String[n];
    for (int d = w - 1; d >= 0; d--) {
      int[] count = new int[r + 1];
      for (int i = 0; i < n; i++) {
        count[a[i].charAt(d) + 1]++;
      }
      for (int j = 0; j < r; j++) {
        count[j + 1] += count[j];
      }
      for (int i = 0; i < n; i++) {
        aux[count[a[i].charAt(d)]++] = a[i];
      }
      for (int i = 0; i < n; i++) {
        a[i] = aux[i];
      }
    }
  }
}
