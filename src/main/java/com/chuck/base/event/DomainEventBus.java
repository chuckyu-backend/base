package com.chuck.base.event;

import java.util.List;

/**
 * @author Administrator
 * @since 2021/8/14
 * @version 0.0.1
 * @apiNote Value Object
 */
@Deprecated
public interface DomainEventBus<T> {
  /** registers a new subscribable to this EventBus instance */
  void register(DomainEventSubscriber subscribabler);

  /**
   * send the given event in this EventBus implementation to be consumed by interested subscribers
   */
  void dispatch(DomainEvent event);

  /** get the list of all the subscribers associated with this EventBus instance */
  List<DomainEventSubscriber> subscribers();
}
