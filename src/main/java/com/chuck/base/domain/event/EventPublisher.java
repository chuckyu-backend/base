package com.chuck.base.domain.event;

import com.chuck.base.client.dto.event.DomainEvent;

/**
 * Chuck 4/10/21 19:52
 */
public interface EventPublisher<T extends DomainEvent> {

    public void publish(T anEvent);
}
