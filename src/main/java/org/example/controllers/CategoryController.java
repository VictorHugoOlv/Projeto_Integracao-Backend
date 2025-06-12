package org.example.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.dto.CategoryDTO;
import org.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Categorias")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{lineId}")
    public List<CategoryDTO> getCategoriesByLine(@PathVariable("lineId") Long lineId) {
        return categoryService.getCategoriesByLine(lineId);
    }
}
