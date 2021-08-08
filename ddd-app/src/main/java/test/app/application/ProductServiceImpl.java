package test.app.application;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.app.application.assemblier.ProductInfoAssemblier;
import test.app.application.dto.ProductCreateParameters;
import test.app.application.dto.ProductGetParameters;
import test.app.application.dto.ProductInfo;
import test.app.domain.product.Product;
import test.app.domain.product.ProductFactory;
import test.app.domain.product.ProductRepository;

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
