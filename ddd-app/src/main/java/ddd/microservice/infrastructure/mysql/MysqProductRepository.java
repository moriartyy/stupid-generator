package ddd.microservice.infrastructure.mysql;

import ddd.microservice.domain.product.Product;
import ddd.microservice.domain.product.ProductRepository;

/**
 * @author walter
 */
public class MysqProductRepository implements ProductRepository {

    @Override
    public Product getById(Integer id) {
        return null;
    }

    @Override
    public Product getBySN(String sn) {
        return null;
    }

    @Override
    public void save(Product product) {

    }
}
