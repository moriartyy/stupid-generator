package ddd.microservice.infrastructure.event;

/**
 * @author walter
 */
public interface EventListener {

    void onEvent(Event event);
}
