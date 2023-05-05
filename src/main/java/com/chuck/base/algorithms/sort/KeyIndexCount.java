package com.chuck.base.algorithms.sort;

import java.util.Arrays;

/** 键索引计数排序 */
public class KeyIndexCount {
  public static void sort(String[] a) {
    int r = Arrays.stream(a).distinct().toArray().length;
    int n = a.length;
    String[] aux = new String[n];
    int[] count = new int[r + 1];
    //    计算出现频率
    //    通过频率计算出对应的排序后下标
    //    回写到原数组
  }
}
