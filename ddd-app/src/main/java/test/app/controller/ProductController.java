package test.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import test.app.application.ProductService;
import test.app.application.ProductServiceImpl;
import test.app.application.dto.ProductCreateParameters;
import test.app.application.dto.ProductGetParameters;
import test.app.application.dto.ProductInfo;

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
