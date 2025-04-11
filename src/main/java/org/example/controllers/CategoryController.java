package org.example.controllers;

import org.example.helper.DataBaseHelper;
import org.example.models.Category;
import org.example.models.Line;

import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class CategoryController {


    public List<Category> getCategoryBySelectedLine(Line selectedLine) {
        try (Session session = DataBaseHelper.getSession()) {
            Query<Category> query = session.createQuery(
                    "FROM Category c WHERE c.line = :line", Category.class);
            query.setParameter("line", selectedLine);
            return query.getResultList();
        }
    }

    public List<Category> getAllCategories() {
        try (Session session = DataBaseHelper.getSession()) {
            Query<Category> query = session.createQuery("FROM Category c", Category.class);
            return query.getResultList();
        }
    }
}
