package com.chuck.base.algorithms.adt;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class SimpleGraph implements Graph {
  @Override
  public int v() {
    return v;
  }

  @Override
  public int e() {
    return e;
  }

  @Override
  public void addEdge(int v, int w) {
    adj[v].add(w);
    adj[w].add(v);
    e++;
  }

  @Override
  public Iterable<Integer> adj(int v) {
    return adj[v];
  }

  private final int v;

  private int e;

  private Bag<Integer>[] adj;

  public SimpleGraph(int v) {
    this.v = v;
    this.e = 0;
    this.adj = (Bag<Integer>[]) new Bag[v];
    for (int i = 0; i < v; i++) {
      adj[i] = new Bag<Integer>();
    }
  }

  public SimpleGraph(In in) {
    this(in.readInt());
    int e = in.readInt();
    for (int i = 0; i < e; i++) {
      int v = in.readInt();
      int w = in.readInt();
      addEdge(v, w);
    }
  }

  @Override
  public String toString() {
    String s = v() + " vertices, " + e() + " edges\n";
    for (int v = 0; v < v(); v++) {
      s += v + ": ";
      for (int w : this.adj(v)) {
        s += w + " ";
      }
      s += "\n";
    }
    return s;
  }
}
