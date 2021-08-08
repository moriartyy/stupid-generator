package test.app.application.assemblier;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.app.application.dto.ProductInfo;
import test.app.domain.product.Product;
import test.app.domain.product.ProductRepository;

/**
 * @author walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProductInfoAssemblier {

    private final ProductRepository productRepository;

    public ProductInfo assemble(Product product) {
        ProductInfo pi = new ProductInfo();
        pi.setId(product.getId());
        return pi;
    }
}
