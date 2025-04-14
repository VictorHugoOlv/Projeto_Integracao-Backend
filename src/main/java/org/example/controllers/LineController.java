package org.example.controllers;

import org.example.helper.DataBaseHelper;
import org.example.models.Line;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LineController {

    public List<Line> getAllLines() {
        try (Session session = DataBaseHelper.getSession()) {
            Query<Line> query = session.createQuery("FROM Line", Line.class);
            return query.getResultList();
        }
    }

    public Set<Line> getDistinctLinesSorted() {
        return getAllLines().stream()
                .filter(line -> line != null)
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
