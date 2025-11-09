package service;

import model.Product;
import java.util.ArrayList;

public interface ProductService {
    
    void addProduct(String name, long price);
    ArrayList<Product> getAllProducts();

}