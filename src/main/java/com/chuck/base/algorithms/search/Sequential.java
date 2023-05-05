package com.chuck.base.algorithms.search;

public class Sequential<K, V> {

  private class Node {
    K key;
    V value;
    Node next;

    public Node(K key, V value, Node next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }
  }

  private Node first;

  public V get(K key) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        return x.value;
      }
    }
    return null;
  }

  /**
   * 头插法
   *
   * @param key
   * @param value
   */
  public void put(K key, V value) {
    for (Node x = first; x != null; x = x.next) {
      if (key.equals(x.key)) {
        x.value = value;
        return;
      }
      first = new Node(key, value, first);
    }
  }
}
