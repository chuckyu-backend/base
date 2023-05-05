package com.chuck.base.algorithms.adt;

/** 图是否双色？ */
public class TwoColor {

  public TwoColor(Graph g) {
    marked = new boolean[g.v()];
    color = new boolean[g.v()];
    for (int i = 0; i < g.v(); i++) {
      if (!marked[i]) {
        dfs(g, i);
      }
    }
  }

  private boolean[] marked;

  private boolean[] color;

  private boolean isTwoColorable = true;

  private void dfs(Graph g, int v) {
    marked[v] = true;
    for (int w : g.adj(v)) {
      if (!marked[w]) {
        color[w] = !color[v];
        dfs(g, w);
      } else if (color[w] == color[v]) {
        isTwoColorable = false;
      }
    }
  }

  public boolean isBipartite() {
    return isTwoColorable;
  }
}
