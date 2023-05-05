package com.chuck.base.algorithms.adt;

/**
 * 图，待删除
 *
 * @see edu.princeton.cs.algs4.Graph
 */
@Deprecated
public interface Graph {
  /**
   * 顶点数
   *
   * @return
   */
  int v();

  /**
   * 边数
   *
   * @return
   */
  int e();

  /**
   * 添加边v-w
   *
   * @param v
   * @param w
   */
  void addEdge(int v, int w);

  /**
   * 和v相邻的所有顶点
   *
   * @param v
   * @return
   */
  Iterable<Integer> adj(int v);
}
