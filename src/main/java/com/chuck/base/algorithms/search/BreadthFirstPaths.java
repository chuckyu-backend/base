package com.chuck.base.algorithms.search;

import com.chuck.base.algorithms.adt.Graph;
import edu.princeton.cs.algs4.Queue;

import java.util.Stack;

public class BreadthFirstPaths {

  private boolean[] markded;

  private final int s;

  private int[] edgeTo;

  public BreadthFirstPaths(Graph g, int s) {
    markded = new boolean[s];
    edgeTo = new int[g.v()];
    this.s = s;
    bfs(g, s);
  }

  private void bfs(Graph g, int s) {
    markded[s] = true;
    Queue<Integer> queue = new Queue<>();
    queue.enqueue(s);
    while (!queue.isEmpty()) {
      int v = queue.dequeue();
      for (int w : g.adj(v)) {
        if (!markded[w]) {
          edgeTo[w] = v;
          markded[w] = true;
          queue.enqueue(w);
        }
      }
    }
  }

  public boolean hasPathTo(int v) {
    return markded[v];
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

  //  经典版本
  //  queue=[root]
  //  while not queue.empty():
  //          v=queue.popleft()
  //          if viisited(v):
  //              continue
  //          for ch in v.children():
  //              queue.push(ch)
}
