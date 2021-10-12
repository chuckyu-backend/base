package com.chuck.base.domain.event;

/**
 * Chuck 4/10/21 19:52
 */
public interface EventPublisher<T extends DomainEvent> {

    public void publish(T anEvent);
}
