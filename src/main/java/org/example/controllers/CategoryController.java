package org.example.controllers;

import org.example.dto.CategoryDTO;
import org.example.models.Category;
import org.example.models.Line;
import org.example.repositories.CategoryRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<CategoryDTO> getCategoriesByLine(Line line) {
        return categoryRepository.findByLineId(line.getId()).stream().map(this::categoryToDTO).collect(Collectors.toList());
    }

    private CategoryDTO categoryToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setLineId(category.getLine().getId());
        return categoryDTO;
    }
}
