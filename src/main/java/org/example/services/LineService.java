package org.example.services;

import org.example.dto.LineDTO;
import org.example.models.Line;
import org.example.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineService {

    @Autowired
    private LineRepository lineRepository;

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
