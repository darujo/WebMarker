package com.darujo.homework2.product;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Cart {

    private final List<Product> products =new ArrayList<>();
    private final ProductRepository productRepository;
    public boolean addProductToCart(int id){
        Product product = productRepository.getProductForId(id);
        if(product!=null){
            return products.add(product);
        }
        return false;
    }

    @Override
    public String toString() {
        return  products.toString();
    }

    public boolean delProductToCart(int id){
        Product product = productRepository.getProductForId(id);
        if(product!=null){
            return products.remove(product);
        }
        return false;
    }

}
