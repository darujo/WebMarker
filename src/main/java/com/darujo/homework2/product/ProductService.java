package com.darujo.homework2.product;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    public static long idSequence = 0L;
    public Product createNewOrder() {
        Product product = new Product(++idSequence,"Product #" + idSequence,Math.random()*10000);
        productRepository.addProduct(product);
        return product;
    }
    @PostConstruct
    public void init(){
        for (int i = 0; i < 5; i++) {
            createNewOrder();
        }
    }


}
