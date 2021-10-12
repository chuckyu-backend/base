package com.chuck.base.domain.event;

/**
 * Chuck 4/10/21 20:02
 */
public interface EventSubscriber<T extends  DomainEvent> {

    public void handleEvent(T anEvent);
}
