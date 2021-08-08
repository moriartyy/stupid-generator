package test.app.application;

import test.app.application.dto.ProductCreateParameters;
import test.app.application.dto.ProductGetParameters;
import test.app.application.dto.ProductInfo;

/**
 * @author walter
 */
public interface ProductService {

    ProductInfo get(ProductGetParameters productGetParameters);

    Integer create(ProductCreateParameters productCreateParameters);
}
