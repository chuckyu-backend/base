package com.chuck.base.algorithms.adt;

/** 图查询API：连通性查询 */
public class GraphSearch {

  private final Graph g;

  private final int s;
  /**
   * s表示起点
   *
   * @param g
   * @param s
   */
  public GraphSearch(Graph g, int s) {
    this.g = g;
    this.s = s;
  }

  /**
   * v和s是否连通
   *
   * @param v
   * @return
   */
  boolean marked(int v) {
    return false;
  }

  /**
   * 与s连通的顶点总数
   *
   * @return
   */
  int count() {
    return 0;
  }
}
