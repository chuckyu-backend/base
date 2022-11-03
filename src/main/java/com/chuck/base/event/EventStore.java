package com.chuck.base.event;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

import com.chuck.base.infra.event.EventStoreRepository;

/**
 * 事件存储（当前项目未采用）
 *
 * @author Chuck
 * @since 7/25/2021
 * @version 0.0.1
 * @apiNote
 */
@Deprecated
public class EventStore {

  private EventStoreRepository eventStoreRepository;

  public void append(DomainEvent aDomainEvent) {
    //    在Event内部进行序列化
    //    String eventSerialization = EventStore.objectSerializer().serialize(aDomainEvent);
    //    String eventSerialization = objectMapper.writeValueAsString(aDomainEvent);

    Event event =
        new Event(aDomainEvent.getClass().getName(), aDomainEvent.occurredOn(), aDomainEvent);
    eventStoreRepository.save(event);
  }
}
