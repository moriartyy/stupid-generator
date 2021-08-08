package ddd.microservice.domain;

import ddd.microservice.infrastructure.event.Event;

/**
 * @author walter
 */
public interface TransactionalEventPublisher {
    void publish(Event event);
}
