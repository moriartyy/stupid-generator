package ddd.microservice.application.event.handler;

import ddd.microservice.infrastructure.event.Event;
import ddd.microservice.infrastructure.event.EventHandler;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class ProductCreatedHandler implements EventHandler {

    public static final String PRODUCT_CREATED = "PRODUCT_CREATED";

    @Override
    public boolean canHandle(String eventType) {
        return PRODUCT_CREATED.equals(eventType);
    }

    @Override
    public void handle(Event event) {
        throw new UnsupportedOperationException();
    }

}
