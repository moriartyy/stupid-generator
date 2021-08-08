package ddd.microservice.infrastructure.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
@Component
public class EventHandlerDispatcher implements BeanFactoryAware, InitializingBean {

    private BeanFactory beanFactory;
    private final List<EventHandler> handles = new ArrayList<>(20);

    public void handle(Event event) {
        Optional<EventHandler> handler = this.handles.stream()
                .filter(h -> h.canHandle(event.getType()))
                .findFirst();

        if (handler.isPresent()) {
            handler.get().handle(event);
        } else {
            throw new RuntimeException("No handler found for event type " + event.getType());
        }

    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void afterPropertiesSet() {
        if (beanFactory instanceof ListableBeanFactory) {
            this.handles.addAll(
                    ((ListableBeanFactory) beanFactory).getBeansOfType(EventHandler.class).values());
        }

    }
}
