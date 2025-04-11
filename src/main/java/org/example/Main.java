package org.example;

import org.example.controllers.*;
import org.example.models.*;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        LineController lineController = new LineController(session);
        CategoryController categoryController = new CategoryController(session);
        ProductController productController = new ProductController(session);

        for (Line l : lineController.getAllLines()) {
            System.out.println(l);
        }

        for (Category c : categoryController.getAllCategories()) {
            System.out.println(c);
        }

        for (Product p : productController.getAllProducts()) {
            System.out.println(p);
        }


        System.out.println("Linhas e suas categorias:");
        List<Line> lines = lineController.getAllLines();

        for (Line line : lines) {
            System.out.println("Linha: " + line.getLineName());
            List<Category> categories = categoryController.getCategoryBySelectedLine(line);

            for (Category cat : categories) {
                System.out.println("  Categoria: " + cat.getCategoryName());
                List<Product> products = productController.getProductBySelectedCategory(cat);

                for (Product product : products) {
                    System.out.println("  Produto: " + product.getProductName());
                }
            }
        }
    }
}