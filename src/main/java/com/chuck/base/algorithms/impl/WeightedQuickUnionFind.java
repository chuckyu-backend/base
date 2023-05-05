package com.chuck.base.algorithms.impl;

import com.chuck.base.algorithms.adt.UnionFind;

/** 唯一可能的优化方向就是路径压缩（每个id[i]直接链接到根触点，而不是父触点） */
public class WeightedQuickUnionFind extends UnionFind {
  public WeightedQuickUnionFind(int n) {
    super(n);
    this.sz = new int[n];
    for (int i = 0; i < n; i++) {
      sz[i] = i;
    }
  }

  /** 连通分量标识（标识的是链接的上个触点，形成了森林） */
  private int[] id;
  /** 连通分量数量 */
  private int count;
  /** 由触点索引的各个根节点所对应的分量大小 */
  private int[] sz;

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
    if (sz[pRoot] < sz[qRoot]) {
      id[pRoot] = qRoot;
      sz[qRoot] += sz[pRoot];
    } else {
      id[qRoot] = pRoot;
      sz[pRoot] += sz[qRoot];
    }
    count--;
  }
}
