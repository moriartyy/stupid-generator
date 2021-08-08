package ddd.microservice.controller;

import ddd.microservice.application.ProductService;
import ddd.microservice.application.ProductServiceImpl;
import ddd.microservice.application.dto.ProductCreateParams;
import ddd.microservice.application.dto.ProductGetParams;
import ddd.microservice.application.dto.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController implements ProductService {

    private final ProductServiceImpl productServiceImpl;


    @RequestMapping(path = "product/get")
    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        return productServiceImpl.get(productGetParams);
    }

    @RequestMapping(path = "product/create")
    @Override
    public Integer create(ProductCreateParams productCreateParams) {
        return productServiceImpl.create(productCreateParams);
    }
}
