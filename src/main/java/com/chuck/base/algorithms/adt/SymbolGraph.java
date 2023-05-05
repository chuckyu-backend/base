package com.chuck.base.algorithms.adt;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {

  private ST<String, Integer> st;

  private String[] keys;

  private Graph g;

  public SymbolGraph(String stream, String delim) {
    st = new ST<>();
    In in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(delim);
      for (int i = 0; i < a.length; i++) {
        if (!st.contains(a[i])) st.put(a[i], st.size());
      }
    }
    keys = new String[st.size()];
    for (String name : st.keys()) {
      keys[st.get(name)] = name;
    }
    g = new SimpleGraph(st.size());
    in = new In(stream);
    while (in.hasNextLine()) {
      String[] a = in.readLine().split(delim);
      int v = st.get(a[0]);
      for (int i = 0; i < a.length; i++) g.addEdge(v, st.get(a[i]));
    }
  }

  boolean contains(String key) {
    return st.contains(key);
  }

  int index(String key) {
    return st.get(key);
  }

  String name(int v) {
    return keys[v];
  }

  Graph g() {
    return g;
  }
}
