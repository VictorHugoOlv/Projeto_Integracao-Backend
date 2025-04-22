package org.example.controllers;

import org.example.helper.DataBaseHelper;

import org.example.models.Category;
import org.example.models.Line;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class CategoryController {

    public List<Category> getCategoriesByLine(Line line) {
        Session session = DataBaseHelper.getSession();

        if (session == null){
            return new ArrayList<Category>();
        }

        Query<Category> query = session.createQuery(
                "SELECT DISTINCT c FROM Category c LEFT JOIN FETCH c.products " +
                        "WHERE c.line = :line", Category.class
        );
        query.setParameter("line", line);
        return query.list();
    }
}
