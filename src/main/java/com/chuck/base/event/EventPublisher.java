package com.chuck.base.event;

/** Chuck 4/10/21 19:52 */
@Deprecated
public interface EventPublisher<T extends DomainEvent> {

  public void publish(T anEvent);
}
