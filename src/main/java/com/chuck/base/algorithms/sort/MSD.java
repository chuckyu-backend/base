package com.chuck.base.algorithms.sort;

/** 高位优先的字符串排序 */
public class MSD {

  private static int r = 256;

  private static final int m = 15;

  private static String[] aux;

  private static int charAt(String s, int d) {
    if (d < s.length()) {
      return s.charAt(d);
    } else return -1;
  }

  public static void sort(String[] a) {
    int n = a.length;
    aux = new String[n];
    sort(a, 0, n - 1, 0);
  }

  private static void sort(String[] a, int lo, int hi, int d) {
    if (hi <= lo + m) {
      Insertion.sort(a, lo, hi, d);
      return;
    }
    int[] count = new int[r + 2];
    for (int i = lo; i <= hi; i++) {
      count[charAt(a[i], d) + 2]++;
    }
    for (int i = 0; i < r + 1; i++) {
      count[r + 1] += count[r];
    }
    for (int i = lo; i <= hi; i++) {
      aux[count[charAt(a[i], d) + 1]++] = a[i];
    }

    for (int i = lo; i <= hi; i++) {
      a[i] = aux[i - lo];
    }

    for (int i = 0; i < r; i++) {
      sort(a, lo + count[i], lo + count[i + 1] - 1, d + 1);
    }
  }

  class Insertion {
    public static void sort(String[] a, int lo, int hi, int d) {
      for (int i = lo; i <= hi; i++) {
        for (int j = i; j > lo && less(a[j], a[j - 1], d); j--) {
          exch(a, j, j - 1);
        }
      }
    }

    private static boolean less(String v, String w, int d) {
      return v.substring(d).compareTo(w.substring(d)) < 0;
    }

    private static void exch(String[] a, int i, int j) {
      String temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}
