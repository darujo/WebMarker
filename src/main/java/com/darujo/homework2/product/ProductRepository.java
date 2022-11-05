package com.darujo.homework2.product;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductForId(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + products.toString();
    }

}
