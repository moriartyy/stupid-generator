package ddd.microservice.infrastructure.event;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author walter
 */
@Data
public class Event {
    private String id;
    private String version;
    private String type;
    private LocalDateTime whenCreated;
    private Map<String, Object> details;

    private Event(String id, Map<String, Object> details) {
        this.id = id;
        this.details = Collections.unmodifiableMap(details);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String id = UUID.randomUUID().toString();
        private final Map<String, Object> details = new HashMap<>();

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder put(String key, Object value) {
            this.details.put(key, value);
            return this;
        }

        public Builder putAll(Map<String, Object> details) {
            this.details.putAll(details);
            return this;
        }

        public Event build() {
            return new Event(id, details);
        }
    }
}
