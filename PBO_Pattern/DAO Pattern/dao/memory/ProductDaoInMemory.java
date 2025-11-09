package dao.memory;

import java.util.ArrayList;
import model.Product;
import dao.ProductDao;

public class ProductDaoInMemory implements ProductDao {
    private final ArrayList<Product> storage = new ArrayList<>();

    public ProductDaoInMemory(){
        storage.add(new Product(1, "Laptop", 15000000));
        storage.add(new Product(2, "Smartphone", 8000000));
    }

    @Override
    public void save(Product product) {
        storage.add(product);
    }

    @Override
    public ArrayList<Product> findAll() {
        return storage;
    }
    
}