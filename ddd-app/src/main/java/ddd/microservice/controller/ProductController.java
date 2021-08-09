package ddd.microservice.controller;

import ddd.microservice.contract.ProductService;
import ddd.microservice.contract.ProductServiceImpl;
import ddd.microservice.contract.dto.ProductCreateParams;
import ddd.microservice.contract.dto.ProductGetParams;
import ddd.microservice.contract.dto.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController implements ProductService {

    private final ProductServiceImpl productServiceImpl;

    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        return productServiceImpl.get(productGetParams);
    }

    @Override
    public Integer create(ProductCreateParams productCreateParams) {
        return productServiceImpl.create(productCreateParams);
    }
}
