package com.chuck.base.algorithms.adt;

import java.util.ArrayList;

/** 图路径查询 */
public class GraphPaths {

  private final Graph g;

  private final int s;
  /**
   * 从起点s开始的路径
   *
   * @param g
   * @param s
   */
  public GraphPaths(Graph g, int s) {
    this.g = g;
    this.s = s;
  }

  /**
   * 到点v是否存在路径
   *
   * @param v
   * @return
   */
  boolean hasPathTo(int v) {
    return false;
  }

  /**
   * 返回s到v的路径
   *
   * @param v
   * @return
   */
  Iterable<Integer> pathTo(int v) {
    return new ArrayList<>();
  }
}
