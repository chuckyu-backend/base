package com.chuck.base.event;

/** Chuck 4/10/21 20:02 */
@Deprecated
public interface EventSubscriber<T extends DomainEvent> {

  public void handleEvent(T anEvent);
}
