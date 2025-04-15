package org.example.controllers;

import org.example.helper.DataBaseHelper;
import org.example.models.Line;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LineController {

    public List<Line> getAllLines() {
        try (Session session = DataBaseHelper.getSession()) {
            Query<Line> query = session.createQuery("FROM Line", Line.class);
            return query.getResultList();
        }
    }
}
