package ddd.microservice.application;

import ddd.microservice.application.assemblier.ProductInfoAssemblier;
import ddd.microservice.application.dto.ProductCreateParams;
import ddd.microservice.application.dto.ProductGetParams;
import ddd.microservice.application.dto.ProductInfo;
import ddd.microservice.domain.TransactionalEventPublisher;
import ddd.microservice.domain.product.Product;
import ddd.microservice.domain.product.ProductFactory;
import ddd.microservice.domain.product.ProductRepository;
import ddd.microservice.infrastructure.event.Event;
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
    private final TransactionalEventPublisher transactionalEventPublisher;

    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        Product product = this.productRepository.getById(productGetParams.getId());
        return this.productInfoAssemblier.assemble(product);
    }

    @Override
    public Integer create(ProductCreateParams productCreateParams) {
        Product p = ProductFactory.newInstance()
                .withSN(productCreateParams.getSn())
                .withName(productCreateParams.getName())
                .create();

        this.productRepository.save(p);

        Event productSaved = Event.builder()
                .put("id", p.getId())
                .put("sn", p.getSn())
                .put("name", p.getName())
                .build();

        raiseEvent(productSaved);

        return p.getId();
    }

    private void raiseEvent(Event event) {
        this.transactionalEventPublisher.publish(event);
    }

}
