package com.chuck.base.algorithms.impl;

import com.chuck.base.algorithms.adt.UnionFind;

public class UnionQuickFind extends UnionFind {
  public UnionQuickFind(int n) {
    super(n);
  }

  /** 连通分量标识 */
  private int[] id;
  /** 连通分量数量 */
  private int count;

  /**
   * 这种方案find快，但union慢，所以叫quick-find
   *
   * @param p
   * @return
   */
  public int find(int p) {
    return id[p];
  }

  public void union(int p, int q) {
    int pId = id[p];
    int qId = id[q];
    if (pId == qId) {
      return;
    }
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pId) {
        id[i] = qId;
      }
    }
    count--;
  }
}
