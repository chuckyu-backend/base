package com.chuck.base.algorithms.sort;

public class Insertion {

  public static void sort(Comparable[] a) {
    // for length n from 1~n-1, switch a[i-1] a[i]
    int len = a.length;
    for (int i = 1; i < len; i++) {
      // j from i-1~0, switch a[i] a[j]
      for (int j = i - 1; j >= 0; j--) {
        if (less(a[j + 1], a[j])) {
          exec(a, j + 1, j);
        }
      }
    }
  }

  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private static void exec(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
