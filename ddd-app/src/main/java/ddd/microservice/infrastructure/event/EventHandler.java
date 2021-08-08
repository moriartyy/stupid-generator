package ddd.microservice.infrastructure.event;

/**
 * @author walter
 */
public interface EventHandler {

    boolean canHandle(String eventType);

    void handle(Event event);
}
