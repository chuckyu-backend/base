package com.chuck.base.algorithms.sort;

/** 三向字符串快速排序：对MSD的改进 */
public class Quick3String {

  private static int charAt(String s, int d) {
    if (d < s.length()) return s.charAt(d);
    else return -1;
  }

  public static void sort(String[] a) {
    sort(a, 0, a.length - 1, 0);
  }

  private static void sort(String[] a, int start, int end, int index) {
    if (end <= start) return;
    int lt = start, gt = end;
    int v = charAt(a[start], index);
    int i = start + 1;
    while (i <= gt) {
      int t = charAt(a[i], index);
      if (t < v) exch(a, lt++, i++);
      else if (t > v) exch(a, i, gt--);
      else i++;
    }
    sort(a, start, lt - 1, index);
    if (v >= 0) sort(a, lt, gt, index + 1);
    sort(a, gt + 1, end, index);
  }

  private static void exch(String[] a, int i, int j) {
    String tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
