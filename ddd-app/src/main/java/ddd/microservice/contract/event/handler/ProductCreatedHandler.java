package ddd.microservice.contract.event.handler;

import ddd.microservice.infrastructure.event.Event;
import ddd.microservice.infrastructure.event.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class ProductCreatedHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException();
    }

}
