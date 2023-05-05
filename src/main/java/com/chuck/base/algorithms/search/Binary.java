package com.chuck.base.algorithms.search;

/**
 * 二分查找
 *
 * @see edu.princeton.cs.algs4.BST
 * @param <T>
 */
public class Binary<T extends Comparable> {
  /**
   * 版本1： 返回key所在下标
   *
   * @param key
   * @param a
   * @return
   */
  public static int rank(int key, int[] a) {
    int lo = 0;
    int hi = a.length - 1;

    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key == a[mid]) {
        return mid;
      }
      if (key < a[mid]) {
        hi = mid - 1;
      } else if (key > a[mid]) {
        lo = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 版本2：递归版本
   *
   * @param key
   * @param a
   * @return
   */
  public static int rankRecursive(int key, int[] a) {
    return rank(key, a, 0, a.length - 1);
  }

  private static int rank(int key, int[] a, int lo, int hi) {
    if (lo > hi) {
      return -1;
    }
    int mid = lo + (hi - lo) / 2;
    if (key < a[mid]) {
      return rank(key, a, lo, mid - 1);
    }
    if (key > a[mid]) {
      return rank(key, a, mid + 1, hi);
    }
    return mid;
  }

  // ====================

  private T[] a;

  public Binary(T[] a) {
    this.a = a;
  }

  private int rank(T key) {
    int lo = 0;
    int hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key.equals(a[mid])) {
        return mid;
      }
      if (key.compareTo(a[mid]) == -1) {
        hi = mid - 1;
      } else if (key.compareTo(a[mid]) == 1) {
        lo = mid + 1;
      }
    }
    return -1;
  }
}
