package com.chuck.base.algorithms.search;

import com.chuck.base.algorithms.adt.CC;
import com.chuck.base.algorithms.adt.Graph;

public class DepthFirstCC extends CC {
  public DepthFirstCC(Graph g) {
    super(g);
    marked = new boolean[g.v()];
    id = new int[g.v()];
    for (int i = 0; i < g.v(); i++) {
      if (!marked[i]) {
        dfs(g, i);
        count++;
      }
    }
  }

  private boolean[] marked;

  private int[] id;

  private int count;

  private void dfs(Graph g, int v) {
    marked[v] = true;
    id[v] = count;
    for (int w : g.adj(v)) {
      if (!marked[w]) {
        dfs(g, w);
      }
    }
  }

  public boolean connected(int v, int w) {
    return id[v] == id[w];
  }

  public int id(int v) {
    return id[v];
  }

  public int count() {
    return count;
  }
}
