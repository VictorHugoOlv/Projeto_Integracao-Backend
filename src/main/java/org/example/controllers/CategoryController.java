package org.example.controllers;

import org.example.helper.DataBaseHelper;

import org.example.models.Category;
import org.example.models.Line;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.util.List;

public class CategoryController {

    public List<Category> getCategoriesByLine(Line line) {
        try (Session session = DataBaseHelper.getSession()) {
            Query<Category> query = session.createQuery(
                    "SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.products " +
                            "WHERE c.line = :line", Category.class
            );
            query.setParameter("line", line);
            return query.list();
        }
    }
}
