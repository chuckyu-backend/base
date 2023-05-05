package com.chuck.base.algorithms.search;

import com.chuck.base.algorithms.adt.Graph;
import com.chuck.base.algorithms.adt.GraphSearch;

public class DepthFirst extends GraphSearch {
  /** 该字段是必须的 */
  private boolean[] marked;

  private int count;

  public DepthFirst(Graph g, int s) {
    super(g, s);
    marked = new boolean[g.v()];
    dfs(g, s);
  }

  private void dfs(Graph g, int v) {
    marked[v] = true;
    count++;
    for (int w : g.adj(v)) {
      if (!marked[w]) dfs(g, w);
    }
  }

  public boolean marked(int w) {
    return marked[w];
  }

  public int count() {
    return count;
  }
}
