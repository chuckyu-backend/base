package com.chuck.base.domain.core;

@FunctionalInterface
public interface ValueObject<T> {

  T empty();
}
