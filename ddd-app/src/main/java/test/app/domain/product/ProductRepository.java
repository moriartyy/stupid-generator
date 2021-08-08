package test.app.domain.product;

/**
 * @author walter
 */
public interface ProductRepository {
    Product getById(Integer id);

    Product getBySN(String sn);

    void save(Product product);
}
