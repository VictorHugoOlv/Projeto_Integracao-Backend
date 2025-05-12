package org.example.controllers;

import org.example.dto.LineDTO;
import org.example.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lines")
public class LineController {

    @Autowired
    private LineService lineService;

    @GetMapping
    public List<LineDTO> getAllLines() {
        return lineService.getAllLines();
    }
}
