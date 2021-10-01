package com.chuck.base.domain.event;// package com.mmc.base.domain.event;

// import java.util.ArrayList;
// import java.util.List;

// /**
//  * 发布订阅方必须由同一线程来处理
//  * 
//  * @author Chuck
//  * @since 7/25/2021
//  * @version 0.0.1
//  * @apiNote
//  **/
// public class DomainEventPublisher {

//     private static final ThreadLocal<List> subscribers = new ThreadLocal<List>();

//     private static final ThreadLocal<Boolean> publishing = new ThreadLocal<Boolean>() {
//         protected Boolean initialValue() {
//             return Boolean.FALSE;
//         }
//     };

//     public static DomainEventPublisher instance() {
//         return new DomainEventPublisher();
//     }

//     public DomainEventPublisher() {
//         super();
//     }

//     public <T> void publish(final T aDomainEvent) {
//         if (publishing.get()) {
//             return;
//         }
//         try {
//             publishing.set(Boolean.TRUE);
//             List<DomainEventSubscriber<T>> registeredSubscribers = subscribers.get();
//             if (registeredSubscribers != null) {
//                 Class<?> eventType = aDomainEvent.getClass();
//                 for (DomainEventSubscriber<T> subscriber : registeredSubscribers) {
//                     Class<?> subscribedTo = subscriber.subscribedToEventType();
//                     if (subscribedTo == eventType || subscribedTo == DomainEvent.class) {
//                         subscriber.handleEvent(aDomainEvent);
//                     }
//                 }
//             }
//         } finally {
//             publishing.set(Boolean.FALSE);
//         }
//     }

//     public DomainEventPublisher reset() {
//         if (!publishing.get()) {
//             subscribers.set(null);
//         }
//         return this;
//     }

//     public <T> void subscribe(DomainEventSubscriber<T> aSubscriber) {
//         if (publishing.get()) {
//             return;
//         }
//         List<DomainEventSubscriber<T>> registeredSubscribers = subscribers.get();
//         if (registeredSubscribers == null) {
//             registeredSubscribers = new ArrayList<DomainEventSubscriber<T>>();
//             subscribers.set(registeredSubscribers);
//         }
//         registeredSubscribers.add(aSubscriber);
//     }
// }
