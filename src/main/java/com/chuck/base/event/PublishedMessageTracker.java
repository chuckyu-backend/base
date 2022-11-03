package com.chuck.base.event;

import lombok.Data;

/**
 * 更新事件的状态（已被发布、未发布等），对应数据库表
 *
 * @author Chuck
 * @since 2021年7月25日
 * @version 0.0.1
 * @apiNote
 */
@Data
@Deprecated
public class PublishedMessageTracker {
  /** 对应eventId、messageId */
  private long mostRecentPublishedMessageId;

  private long trackerId;
  /** 对应topic、channel */
  private String type;

  public long mostRecentPublishedMessageId() {
    return this.getMostRecentPublishedMessageId();
  }
}
