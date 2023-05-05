package com.chuck.base.algorithms.sort;

/**
 * 问题：插入排序的缺点：假设最小的元素在末尾，插入排序要将它移动到头部，需要移动n-1次，这就有了希尔排序
 *
 * <p>希尔排序：使数组中任意间隔为h的元素都是有序的
 *
 * <p>为什么希尔排序相比插入排序更高效：1、排序之初，因为每个子数组都很小，子数组排序之后数组是部分有序的，这两种情况都适合插入排序
 */
public class Shell {

  public static void sort(Comparable[] a) {
    int len = a.length;
    int h = 1;
    while (h < len / 3) {
      h = 3 * h + 1;
    }
    while (h >= 1) {
      for (int i = h; i < len; i++) {
        for (int j = i; j >= h; j -= h) {
          if (less(a[j], a[j - h])) exec(a, j, j - h);
        }
      }
      h = h / 3;
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

  private static void execInPlace(int[] a, int i, int j) {
    a[i] = a[i] + a[j];
    a[j] = a[i] - a[j];
    a[i] = a[i] - a[j];
  }

  public static void sort1(Comparable[] a) {
    int n = a.length;
    for (int step = n / 2; step > 0; step /= 2) {
      for (int i = step; i < n; i++) {
        for (int j = i - step; j >= 0; j -= step) { // 插入排序1：最初就是两个元素进行排序
          if (less(a[j + step], a[j])) {
            exec(a, j + step, j);
          }
        }

        //        Comparable temp = a[i]; // 插入排序2
        //        int j = i - step;
        //        while (j >= 0 && less(temp, a[j])) {
        //          a[j + step] = a[j];
        //          j -= step;
        //        }
        //        a[j + step] = temp;
      }
    }
  }
}
