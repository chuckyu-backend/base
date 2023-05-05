package com.chuck.base.algorithms.adt;

/**
 * 判断是否无环图API
 *
 * @see edu.princeton.cs.algs4.Cycle
 */
@Deprecated
public class Cycle {

  private boolean[] marked;

  private boolean hasCycle;

  public Cycle(Graph g) {
    marked = new boolean[g.v()];
    for (int i = 0; i < g.v(); i++) {
      if (!marked[i]) {
        dfs(g, i, i);
      }
    }
  }

  private void dfs(Graph g, int v, int u) {
    marked[v] = true;
    for (int w : g.adj(v)) {
      if (!marked[w]) {
        dfs(g, w, v);
      } else if (w != u) {
        hasCycle = true;
      }
    }
  }

  public boolean hasCycle() {
    return hasCycle;
  }
}
