package com.chuck.base.algorithms.search;

import com.chuck.base.algorithms.adt.Graph;
import com.chuck.base.algorithms.adt.GraphPaths;

import java.util.Stack;

public class DepthFirstPaths extends GraphPaths {
  /** 该字段是必须的 */
  private boolean[] marked;

  private int[] edgeTo;

  private final int s;

  /**
   * 从起点s开始的路径
   *
   * @param g
   * @param s
   */
  public DepthFirstPaths(Graph g, int s) {
    super(g, s);
    marked = new boolean[g.v()];
    edgeTo = new int[g.v()];
    this.s = s;
    dfs(g, s);
  }

  private void dfs(Graph g, int s) {
    marked[s] = true;
    for (int w : g.adj(s)) {
      if (!marked[w]) {
        edgeTo[w] = s;
        dfs(g, w);
      }
    }
  }

  public boolean hasPathTo(int v) {
    return marked[v];
  }

  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v)) return null;
    Stack<Integer> path = new Stack<>();
    for (int i = v; i != s; i = edgeTo[i]) {
      path.push(i);
    }
    path.push(s);
    return path;
  }
  // 经典版本
  //  stack=[root]
  //  while not stack.empty():
  //          v=stack.pop()
  //          if viisited(v):
  //              continue
  //          for ch in v.children():
  //              stack.push(ch)

}
