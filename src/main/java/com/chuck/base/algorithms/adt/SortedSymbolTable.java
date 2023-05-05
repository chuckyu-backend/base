package com.chuck.base.algorithms.adt;

public interface SortedSymbolTable<K extends Comparable<K>, V> {

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

  //  其他
  K min();

  K max();

  K floor(K key);

  K ceiling(K key);

  int rank(K key);

  K select(int k);

  default void deleteMin() {
    delete(min());
  }

  default void deleteMax() {
    delete(max());
  }

  default int size(K lo, K hi) {
    if (hi.compareTo(lo) < 0) {
      return 0;
    } else if (contains(hi)) {
      return rank(hi) - rank(lo) + 1;
    }
    return rank(hi) - rank(lo);
  }

  default Iterable<K> keys(K lo, K hi) {
    return keys(min(), max());
  }
}
