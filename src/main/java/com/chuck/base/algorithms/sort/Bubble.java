package com.chuck.base.algorithms.sort;

public class Bubble {
  public static void sort(Comparable[] a) {
    int n = a.length;
    for (int i = n - 1; i > 0; i--) {
      for (int j = 0; j < i; j++) {
        if (less(a[j + 1], a[j])) {
          exec(a, j, j + 1);
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
