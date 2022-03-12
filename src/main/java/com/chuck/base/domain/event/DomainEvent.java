package com.chuck.base.domain.event;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Chuck
 * @since 7/4/2021
 * @version 0.0.1
 * @apiNote
 */
public interface DomainEvent extends Serializable {
  /**
   * 指定事件发生的时间
   *
   * @return
   */
  default LocalDateTime occurredOn() {
    return LocalDateTime.now();
  }
}
