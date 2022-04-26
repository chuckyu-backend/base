package com.chuck.base.app.event;// package com.mmc.base.domain.event;

// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// /**
//  * 事件存储（当前项目未采用）
//  * 
//  * @author Chuck
//  * @since 7/25/2021
//  * @version 0.0.1
//  * @apiNote
//  **/
// public class EventStore {

//     private ObjectMapper objectMapper = new ObjectMapper();

//     private EventStoreRepository eventStoreRepository;

//     public void append(DomainEvent aDomainEvent) throws JsonProcessingException {
//         // String eventSerialization =
//         // EventStore.objectSerializer().serialize(aDomainEvent);
//         String eventSerialization = objectMapper.writeValueAsString(aDomainEvent);

//         StoredEvent storedEvent = new StoredEvent(aDomainEvent.getClass().getName(), aDomainEvent.occurredOn(),
//                 eventSerialization);
//         eventStoreRepository.save(storedEvent);

//     }
// }
