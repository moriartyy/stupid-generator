package ddd.microservice.domain.product;

import ddd.microservice.domain.Repository;

/**
 * @author walter
 */
public interface ProductRepository extends Repository {

    Product getById(Integer id);

    Product getBySN(String sn);

    void save(Product product);

}
