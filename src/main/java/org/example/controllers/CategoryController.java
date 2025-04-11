package org.example.controllers;

import org.example.models.Category;
import org.example.models.Line;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class CategoryController {
    private Session session;

    public CategoryController(Session session) {
        this.session = session;
    }

    public List<Category> getCategoryBySelectedLine(Line selectedLine) {
        Query<Category> query = session.createQuery(
                "FROM Category c WHERE c.line = :line", Category.class);
        query.setParameter("line", selectedLine);
        return query.getResultList();
    }

    public List<Category> getAllCategories() {
        Query<Category> query = session.createQuery("FROM Category c", Category.class);
        return query.getResultList();
    }
}
