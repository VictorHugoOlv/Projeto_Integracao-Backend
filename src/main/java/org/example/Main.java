package org.example;

import org.example.controllers.*;
import org.example.models.Line;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LineController lineController = new LineController();
        List<Line> lines = lineController.getAllLines();

        System.out.println(lines.get(0).getLineName());
    }
}