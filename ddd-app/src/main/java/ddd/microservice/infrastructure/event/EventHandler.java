package ddd.microservice.infrastructure.event;

import com.google.common.base.CaseFormat;

/**
 * @author walter
 */
public interface EventHandler {

    void handle(Event event);

    default String getEventType() {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, this.getClass().getName().replace("Handler", ""));
    }
}
