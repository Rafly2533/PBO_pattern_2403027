package service;

import model.Product;
import java.util.ArrayList;

public class ProductServiceDefault implements ProductService{
    private final ArrayList<Product> productsList = new ArrayList<>();

    public ProductServiceDefault(){
        productsList.add(new Product(1 , "Laptop Asus", 950000));
        productsList.add(new Product(2 , "Monitor Dell", 2500000));
    }

    @Override
    public void addProduct(String name, long price){
        if (price <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari 0");
        }
        int newId = productsList.size() + 1;
        productsList.add(new Product(newId, name, price));
        
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return productsList;
    }
    
}