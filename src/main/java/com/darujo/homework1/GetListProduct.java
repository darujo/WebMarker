package com.darujo.homework1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "GetListProduct", urlPatterns = "/get_list_product_servlet")
public class GetListProduct extends HttpServlet {
    Product [] products;
    @Override
    public void init()  {
        Random random = new Random();
        products = new Product[10];
        for (int i = 0; i < 10; i++) {
            products[i] = new Product(i,"Product_" + i,random.nextFloat() * 1000  );

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        for (Product product : products) {
            resp.getWriter().printf("<p1>%s</p1>", product.toString());
        }

    }
}
