package ddd.microservice.application.assemblier;

import ddd.microservice.application.dto.ProductInfo;
import ddd.microservice.domain.product.Product;
import ddd.microservice.domain.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
