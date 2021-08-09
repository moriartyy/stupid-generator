package ddd.microservice.contract;

import ddd.microservice.contract.dto.ProductCreateParams;
import ddd.microservice.contract.dto.ProductGetParams;
import ddd.microservice.contract.dto.ProductInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface ProductService {

    @RequestMapping(path = "product/get")
    ProductInfo get(ProductGetParams productGetParams);

    @RequestMapping(path = "product/create")
    Integer create(ProductCreateParams productCreateParams);
}
