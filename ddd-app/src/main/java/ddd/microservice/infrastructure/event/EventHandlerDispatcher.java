package ddd.microservice.infrastructure.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author walter
 */
@Component
public class EventHandlerDispatcher implements BeanFactoryAware, InitializingBean {

    private BeanFactory beanFactory;
    private final Map<String, EventHandler> handles = new ConcurrentHashMap<>();

    public void handle(Event event) {
        EventHandler handler = this.handles.get(event.getType());
        if (handler != null) {
            handler.handle(event);
        } else {
            throw new RuntimeException("No handler found for event type " + event.getType());
        }
    }

    public void addHandler(String eventType, EventHandler eventHandler) {
        this.handles.put(eventType, eventHandler);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
        if (beanFactory instanceof ListableBeanFactory) {
            ((ListableBeanFactory) beanFactory).getBeansOfType(EventHandler.class)
                    .values()
                    .forEach(h-> this.handles.put(h.getEventType(), h));
        }
    }
}
