package ddd.microservice.contract;

import ddd.microservice.contract.assemblier.ProductAssembler;
import ddd.microservice.contract.dto.ProductCreateParams;
import ddd.microservice.contract.dto.ProductGetParams;
import ddd.microservice.contract.dto.ProductInfo;
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
    private final ProductAssembler productAssembler;
    private final TransactionalEventPublisher transactionalEventPublisher;

    @Override
    public ProductInfo get(ProductGetParams productGetParams) {
        Product product = this.productRepository.getById(productGetParams.getId());
        return this.productAssembler.assemble(product);
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
