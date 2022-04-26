package com.chuck.base.client.dto.event;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

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
public class StoredEvent {

  private String eventBody;
  /** 可由数据主键生成 */
  private long eventId;

  private LocalDateTime occurredOn;

  private String typeName;

  public StoredEvent(String aTypeName, LocalDateTime anOccurredOn, String anEventBody) {
    this.setEventBody(anEventBody);
    this.setOccurredOn(anOccurredOn);
    this.setTypeName(aTypeName);
  }
}
