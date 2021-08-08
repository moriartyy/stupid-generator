package ddd.microservice.application.dto;

import lombok.Data;

/**
 * @author walter
 */
@Data
public class ProductCreateParameters {
    private String sn;
    private String name;
}
