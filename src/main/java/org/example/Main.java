package org.example;

import javax.persistence.*;

import org.example.controllers.CategoryController;
import org.example.controllers.LineController;
import org.example.controllers.ProductController;
import org.example.models.Category;
import org.example.models.Line;
import org.example.models.Product;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("example").createEntityManager();

        LineController lineController = new LineController(em);
        CategoryController categoryController = new CategoryController(em);
        ProductController productController = new ProductController(em);

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