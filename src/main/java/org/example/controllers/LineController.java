package org.example.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.LineDTO;
import org.example.services.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Linhas")
@RestController
@RequestMapping("/lines")
public class LineController {

    @Autowired
    private LineService lineService;

    @Operation(summary = "Pega todas as Linhas ")
    @GetMapping
    public List<LineDTO> getAllLines() {
        return lineService.getAllLines();
    }
}
