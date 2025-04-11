package org.example.controllers;

import org.example.models.Category;
//import org.example.models.Line;
import org.example.models.Product;

import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class ProductController {

    public List<Product> getProductBySelectedCategory(Category selectedCategory) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("FROM Product p WHERE p.category = :category", Product.class);
            query.setParameter("category", selectedCategory);
            return query.getResultList();
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery("FROM Product p", Product.class);
            return query.getResultList();
        }
    }
}
