package com.chuck.base.algorithms;

import com.chuck.base.algorithms.adt.Graph;

public class BaseGraphOperator {

  /**
   * v的度数
   *
   * @param g
   * @param v
   * @return
   */
  public static int degree(Graph g, int v) {
    int degree = 0;
    for (int w : g.adj(v)) {
      degree++;
    }
    return degree;
  }

  /**
   * 所有顶点的最大度数
   *
   * @param g
   * @return
   */
  public static int maxDegree(Graph g) {
    int max = 0;
    for (int v = 0; v < g.v(); v++) {
      if (degree(g, v) > max) max = degree(g, v);
    }
    return max;
  }

  /**
   * 平均度数
   *
   * @param g
   * @return
   */
  public static int avgDegree(Graph g) {
    return 2 * g.e() / g.v();
  }

  /**
   * 自环个数
   *
   * @param g
   * @return
   */
  public static int numberOfSelfLoops(Graph g) {
    int count = 0;
    for (int v = 0; v < g.v(); v++) {
      for (int w : g.adj(v)) {
        if (v == w) count++;
      }
    }
    return count / 2;
  }
}
