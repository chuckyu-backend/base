package com.chuck.base.event;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 当前项目未使用
 *
 * @author Chuck
 * @since 2021年7月25日
 * @version 0.0.1
 * @apiNote
 */
@Getter
@Setter
@Deprecated
public class Event<T> {

  private T eventBody;
  /** 可由数据主键生成 */
  private long eventId;

  private LocalDateTime occurredOn;

  private String typeName;

  public Event(String aTypeName, LocalDateTime anOccurredOn, T anEventBody) {
    this.setEventBody(anEventBody);
    this.setOccurredOn(anOccurredOn);
    this.setTypeName(aTypeName);
  }
}
