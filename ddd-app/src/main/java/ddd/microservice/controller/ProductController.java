package ddd.microservice.controller;

import ddd.microservice.application.ProductService;
import ddd.microservice.application.ProductServiceImpl;
import ddd.microservice.application.dto.ProductCreateParameters;
import ddd.microservice.application.dto.ProductGetParameters;
import ddd.microservice.application.dto.ProductInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductController implements ProductService {

    private ProductServiceImpl productServiceImpl;


    @RequestMapping(path = "product/get")
    @Override
    public ProductInfo get(ProductGetParameters productGetParameters) {
        return productServiceImpl.get(productGetParameters);
    }

    @RequestMapping(path = "product/create")
    @Override
    public Integer create(ProductCreateParameters productCreateParameters) {
        return productServiceImpl.create(productCreateParameters);
    }
}
