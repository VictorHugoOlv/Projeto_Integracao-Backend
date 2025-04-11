package org.example.controllers;

import org.example.models.Line;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LineController {
    private Session session;

    public LineController(Session session) {
        this.session = session;
    }

    public List<Line> getAllLines() {
        Query<Line> query = session.createQuery("FROM Line", Line.class);
        return query.getResultList();
    }
}
