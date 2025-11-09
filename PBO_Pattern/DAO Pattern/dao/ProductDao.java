
package dao;

import java.util.ArrayList;
import model.Product;

public interface ProductDao {
    void save(Product product);
    ArrayList<Product> findAll();
}
