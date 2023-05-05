package com.chuck.base.algorithms.impl;

import edu.princeton.cs.algs4.MaxPQ;

public class MaxPQArrayImpl<K extends Comparable<K>> extends MaxPQ {
  private K[] pq; // 数组实现

  private int N = 0; // 0位置不存储元素

  public MaxPQArrayImpl(int maxN) {
    pq = (K[]) new Comparable[maxN + 1];
  }

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  public void insert(K v) {
    pq[++N] = v;
    swim(N);
  }

  public K delMax() {
    K max = pq[1];
    exch(1, N--);
    pq[N + 1] = null;
    sink(1);
    return max;
  }
  //  ==========Private Methods

  private boolean less(int i, int j) {
    return pq[i].compareTo(pq[j]) < 0;
  }

  private void exch(int i, int j) {
    K t = pq[i];
    pq[i] = pq[j];
    pq[j] = t;
  }

  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k / 2, k);
      k = k / 2;
    }
  }

  private void sink(int k) {
    while (2 * k <= N) {
      int j = 2 * k;
      if (j < N && less(j, j + 1)) {
        j++;
      }
      if (!less(k, j)) {
        break;
      }
      exch(k, j);
      k = j;
    }
  }
}
