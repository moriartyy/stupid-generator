package ddd.microservice.application;

import ddd.microservice.application.dto.ProductCreateParams;
import ddd.microservice.application.dto.ProductGetParams;
import ddd.microservice.application.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParams productGetParams);

    Integer create(ProductCreateParams productCreateParams);
}
