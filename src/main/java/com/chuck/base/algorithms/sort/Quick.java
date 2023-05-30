package com.chuck.base.algorithms.sort;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/** 快排相比归并移动的元素更少，所以更快。改进策略：1、小的数组（长度小于16），使用插入排序。2、使用子数组的小部分元素的中位数作为切分元素。3、重复元素不参与排序 */
public class Quick {
  public static void sort(Comparable[] a) {
    StdRandom.shuffle(a);
    sort(a, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, int lo, int hi) {
    if (lo >= hi) return;
    int j = partition(a, lo, hi);
    sort(a, lo, j - 1);
    sort(a, j + 1, hi);
  }

//  public static void main(String[] args) {
//    Integer[] a = new Integer[] {4, 1, 2, 8};
//    sort(a);
//    Arrays.stream(a).forEach(System.out::println);
//  }

  private static int partition(Comparable[] a, int lo, int hi) {
    int i = lo, j = hi + 1;
    Comparable v = a[lo];
    while (true) {
      while (less(a[++i], v)) if (i == hi) break;
      while (less(v, a[--j])) if (j == lo) break;
      if (i >= j) break;
      exch(a, i, j);
    }
    exch(a, lo, j);
    return j;
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
