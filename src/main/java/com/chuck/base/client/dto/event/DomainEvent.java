package com.chuck.base.client.dto.event;

import java.time.LocalDateTime;

/**
 *
 * @author Chuck
 * @since 7/4/2021
 * @version 0.0.1
 * @apiNote
 **/
public interface DomainEvent {
    /**
     * 指定事件发生的时间
     * 
     * @return
     */
    default LocalDateTime occurredOn() {
        return LocalDateTime.now();
    }

}
