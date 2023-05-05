package com.chuck.base.algorithms.impl;

import com.chuck.base.algorithms.adt.UnionFind;

public class QuickUnionFind extends UnionFind {
  public QuickUnionFind(int n) {
    super(n);
  }

  /** 连通分量标识（标识的是链接的上个触点，形成了森林） */
  private int[] id;
  /** 连通分量数量 */
  private int count;

  public int find(int p) {
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int pRoot = find(p);
    int qRoot = find(q);
    if (pRoot == qRoot) {
      return;
    }
    id[pRoot] = qRoot;
    count--;
  }
}
