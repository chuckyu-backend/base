package com.chuck.base.algorithms.sort;

public class Heap {

  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = N / 2; i >= 1; i--) {
      sink(a, i, N); // 循环构造
    }
    while (N > 1) {
      exec(a, 1, N--);
      sink(a, 1, N); // 循环缩减销毁
    }
  }

  private static void sink(Comparable[] a, int i, int n) {
    //    TODO
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
