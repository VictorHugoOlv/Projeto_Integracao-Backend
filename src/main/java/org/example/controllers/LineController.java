package org.example.controllers;

import org.example.models.Line;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class LineController {
    private EntityManager em;

    public LineController(EntityManager em) {
        this.em = em;
    }

    public List<Line> getAllLines() {
        TypedQuery<Line> query = em.createQuery("SELECT l FROM Line l", Line.class);
        return query.getResultList();
    }
}
