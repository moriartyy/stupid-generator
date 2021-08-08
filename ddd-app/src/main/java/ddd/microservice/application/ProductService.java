package ddd.microservice.application;

import ddd.microservice.application.dto.ProductCreateParameters;
import ddd.microservice.application.dto.ProductGetParameters;
import ddd.microservice.application.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParameters productGetParameters);

    Integer create(ProductCreateParameters productCreateParameters);
}
