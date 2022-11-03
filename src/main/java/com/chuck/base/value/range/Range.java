package com.chuck.base.value.range;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Administrator
 * @version 0.0.1
 * @apiNote Value Object
 * @since 2021/8/13
 */
@Getter
@Setter
@AllArgsConstructor
public class Range<T> {

  private T from;

  private T to;
}
