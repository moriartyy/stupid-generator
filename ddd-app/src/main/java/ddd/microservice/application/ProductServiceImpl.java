package ddd.microservice.application;

import ddd.microservice.application.assemblier.ProductInfoAssemblier;
import ddd.microservice.application.dto.ProductCreateParameters;
import ddd.microservice.application.dto.ProductGetParameters;
import ddd.microservice.application.dto.ProductInfo;
import ddd.microservice.domain.product.Product;
import ddd.microservice.domain.product.ProductFactory;
import ddd.microservice.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductInfoAssemblier productInfoAssemblier;

    @Override
    public ProductInfo get(ProductGetParameters productGetParameters) {
        Product product = this.productRepository.getById(productGetParameters.getId());
        return this.productInfoAssemblier.assemble(product);
    }

    @Override
    public Integer create(ProductCreateParameters productCreateParameters) {
        Product p = ProductFactory.newInstance()
                .withSN(productCreateParameters.getSn())
                .withName(productCreateParameters.getName())
                .create();
        this.productRepository.save(p);
        return p.getId();
    }
}
