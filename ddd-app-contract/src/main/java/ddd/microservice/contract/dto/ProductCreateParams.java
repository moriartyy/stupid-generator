package ddd.microservice.contract.dto;

import lombok.Data;

/**
 * @author walter
 */
@Data
public class ProductCreateParams {
    private String sn;
    private String name;
}
