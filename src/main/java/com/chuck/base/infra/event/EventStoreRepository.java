package com.chuck.base.infra.event;

import com.chuck.base.event.Event;

/**
 * 项目未使用
 *
 * @author Chuck
 * @since 2021年7月25日
 * @version 0.0.1
 * @apiNote
 */
public interface EventStoreRepository //        extends JpaRepository<StoredEvent, Long>
 {
  void save(Event event);
}
