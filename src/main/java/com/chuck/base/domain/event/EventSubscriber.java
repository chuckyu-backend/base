package com.chuck.base.domain.event;

import com.chuck.base.client.dto.event.DomainEvent;

/**
 * Chuck 4/10/21 20:02
 */
public interface EventSubscriber<T extends DomainEvent> {

    public void handleEvent(T anEvent);
}
