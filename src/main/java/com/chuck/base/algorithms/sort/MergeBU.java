package com.chuck.base.algorithms.sort;

/** 循序渐进的归并排序 */
public class MergeBU {

  public static void sort(Comparable[] a) {
    int n = a.length;
    aux = new Comparable[n];
    for (int sz = 1; sz < n; sz *= 2) {
      //        sz: 每次合并的子数组大小
      for (int lo = 0; lo < n - sz; lo += 2 * sz) {
        //
        merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, n - 1));
      }
    }
  }

  private static Comparable[] aux;

  private static void merge(Comparable[] a, int lo, int mid, int hi) {

    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        a[k] = aux[j++];
      } else if (j > hi) {
        a[k] = aux[i++];
      } else if (less(aux[j], aux[i])) {
        a[k] = aux[j++];
      } else {
        a[k] = aux[i++];
      }
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
