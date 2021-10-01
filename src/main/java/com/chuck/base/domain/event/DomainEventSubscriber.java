package com.chuck.base.domain.event;

import java.util.Set;

/**
 *
 * 在应用服务中：
 *
 * 1、先订阅领域事件（可以通过AOP方式）：DomainEventSubscriber sub=new
 * DomainEventSubscriber(){...} ；DomainEventPublisher.instance().subscribe(sub);
 *
 *
 *
 * 2、执行自治领域内部操作DomainService，在内部操作中发布领域事件（可以通过AOP方式-@Aspect+@Before("execution(*
 * com.mmc)")）
 *
 * @author Chuck
 * @since 2021年7月25日
 * @version 0.0.1
 * @apiNote
 *
 */
public interface DomainEventSubscriber<T> {

    public Set<Class<T>> subscribedToEventType();// Set<Class<T>> supports();

    public void handleEvent(DomainEvent aDomainEvent);
}
