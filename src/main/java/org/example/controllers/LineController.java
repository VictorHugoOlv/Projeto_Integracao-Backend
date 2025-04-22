package org.example.controllers;

import org.example.helper.DataBaseHelper;
import org.example.models.Line;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class LineController {

    public List<Line> getAllLines() {
        Session session = DataBaseHelper.getSession();

        if (session == null){
            return new ArrayList<Line>();
        }

        Query<Line> query = session.createQuery("FROM Line", Line.class);
        return query.getResultList();
    }
}
