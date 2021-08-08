package ddd.microservice.infrastructure.rocketmq;

import ddd.microservice.infrastructure.event.Event;
import ddd.microservice.infrastructure.event.EventHandlerDispatcher;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class RocketMqEventListener {
    private final EventHandlerDispatcher eventHandlerDispatcher;

    public void onEvent(Event event) {
        this.eventHandlerDispatcher.handle(event);
    }
}
