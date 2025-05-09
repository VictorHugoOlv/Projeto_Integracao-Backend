package org.example.controllers;

import org.example.dto.LineDTO;
import org.example.models.Line;
import org.example.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lines")
public class LineController {

    @Autowired
    private LineRepository lineRepository;

    @GetMapping
    public List<LineDTO> getAllLines() {
        return lineRepository
                .findAll()
                .stream()
                .map(this::lineToDTO)
                .collect(Collectors.toList());
    }

    private LineDTO lineToDTO(Line line) {
        LineDTO lineDTO = new LineDTO();
        lineDTO.setId(line.getId());
        lineDTO.setName(line.getName());
        return lineDTO;
    }
}
