package org.example.controllers;

import org.example.models.Category;
import org.example.models.Line;
import org.example.models.Product;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class ProductController {
    private Session session;

    public ProductController(Session session) {
        this.session = session;
    }

    public List<Product> getProductBySelectedCategory(Category selectedCategory) {
        Query<Product> query = session.createQuery(
                "FROM Product p WHERE p.category = :category", Product.class);
        query.setParameter("category", selectedCategory);
        return query.getResultList();
    }

    public List<Product> getAllProducts() {
        Query<Product> query = session.createQuery("FROM Product p", Product.class);
        return query.getResultList();
    }
}
