package ddd.microservice.infrastructure.rocketmq;

import ddd.microservice.domain.TransactionalEventPublisher;
import ddd.microservice.infrastructure.event.Event;

/**
 * @author walter
 */
public class RocketMqTransactionalEventPublisher implements TransactionalEventPublisher {

    @Override
    public void publish(Event event) {

    }
}
