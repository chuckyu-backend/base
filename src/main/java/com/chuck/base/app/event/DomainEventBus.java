package com.chuck.base.app.event;

import com.chuck.base.client.dto.event.DomainEvent;
import com.chuck.base.domain.event.DomainEventSubscriber;
import java.util.List;

/**
 *
 * @author Administrator
 * @since 2021/8/14
 * @version 0.0.1
 * @apiNote Value Object
 **/
public interface DomainEventBus<T> {
    /**
     * registers a new subscribable to this EventBus instance
     */
    void register(DomainEventSubscriber subscribabler);

    /**
     * send the given event in this EventBus implementation to be consumed by
     * interested subscribers
     */
    void dispatch(DomainEvent event);

    /**
     * get the list of all the subscribers associated with this EventBus instance
     */
    List<DomainEventSubscriber> subscribers();
}
