package com.darujo.homework2;

import com.darujo.homework2.product.Cart;
import com.darujo.homework2.product.ProductRepository;
import com.darujo.homework2.product.ProductService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try(ConfigurableApplicationContext context = new  AnnotationConfigApplicationContext("com.darujo.homework2.product" )) {
            ProductRepository productRepository = context.getBean(ProductRepository.class);
            System.out.println(productRepository);
            Cart cart = context.getBean(Cart.class);
            cart.addProductToCart(2);
            if(!cart.addProductToCart(3)){
                System.out.println("Неудалось создать новый продукт");
            }

            System.out.println(cart);
            if (cart.delProductToCart(2)) {
                System.out.println(cart);
            }
            cart = context.getBean(Cart.class);
            cart.addProductToCart(4);

            System.out.println(cart);
            ProductService productService = context.getBean(ProductService.class);
            System.out.println(productService.createNewOrder());
        }
    }
}
