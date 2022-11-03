package com.chuck.base.event;

/**
 * @author Chuck
 * @since 2021年8月3日
 * @version 0.0.1
 * @apiNote
 */
@Deprecated
public interface GuavaDomainEventSubscriber<T> {

  // public Class<?> subscribedToEventType();

  public void handleEvent(T aDomainEvent);
}
