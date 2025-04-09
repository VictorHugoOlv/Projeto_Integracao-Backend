package org.example.controllers;

import org.example.models.Category;
import org.example.models.Line;
import org.example.models.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductController {
    private EntityManager em;

    public ProductController(EntityManager em) {
        this.em = em;
    }

    public List<Product> getProductBySelectedCategory(Category selectedCategory) {
        TypedQuery<Product> query = em.createQuery(
                "SELECT p FROM Product p WHERE p.category = :category", Product.class);
        query.setParameter("category", selectedCategory);
        return query.getResultList();
    }

    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createQuery("SELECT p FROM Product p", Product.class);
        return query.getResultList();
    }
}
