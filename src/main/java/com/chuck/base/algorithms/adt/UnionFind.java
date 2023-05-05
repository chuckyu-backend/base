package com.chuck.base.algorithms.adt;

/** 判断两个点是否连通 */
public class UnionFind {
  /** 连通分量标识 */
  private int[] id;
  /** 连通分量数量 */
  private int count;

  public UnionFind(int n) {
    this.count = n;
    this.id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }
  // ============================================================================

  public int find(int p) {
    //    TODO
    return id[p];
  }

  public void union(int p, int q) {
    //    TODO
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }
}
