package com.chuck.base.algorithms.adt;

public interface SymbolTable<K, V> {

  void put(K key, V value);

  V get(K key);

  default void delete(K key) {
    put(key, null);
  }

  default boolean contains(K key) {
    return get(key) != null;
  }

  default boolean isEmpty() {
    return size() == 0;
  }

  int size();

  Iterable<K> keys();
}
