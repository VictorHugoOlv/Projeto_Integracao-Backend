package org.example.controllers;

import org.example.models.Category;
import org.example.models.Line;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CategoryController {
    private EntityManager em;

    public CategoryController(EntityManager em) {
        this.em = em;
    }

    public List<Category> getCategoryBySelectedLine(Line selectedLine) {
        TypedQuery<Category> query = em.createQuery(
                "SELECT c FROM Category c WHERE c.line = :line", Category.class);
        query.setParameter("line", selectedLine);
        return query.getResultList();
    }

    public List<Category> getAllCategories() {
        TypedQuery<Category> query = em.createQuery("SELECT c FROM Category c", Category.class);
        return query.getResultList();
    }
}
