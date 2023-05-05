package com.chuck.base.algorithms.sort;

public class Selection {
  /**
   * 选定位置（0~n-1)，择小放置（min）
   *
   * @param a
   */
  public static void sort(Comparable[] a) {
    int len = a.length;
    //      from 0~n-1 set min
    for (int i = 0; i < len - 1; i++) {
      //      from i+1~n find min element
      int min = i;
      for (int j = i + 1; j < len; j++) {
        if (less(a[j], a[min])) {
          min = j;
        }
      }
      exch(a, i, min);
    }
  }

  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }

  private static void exch(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
