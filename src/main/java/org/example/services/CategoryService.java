package org.example.services;

import org.example.dto.CategoryDTO;
import org.example.dto.ProductDTO;
import org.example.models.Category;
import org.example.models.Line;
import org.example.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<CategoryDTO> getCategoriesByLine(Long lineId) {

          return categoryRepository
                .findByLineId(lineId)
                .stream()
                .map(this::categoryToDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO categoryToDTO(Category category) {

        List<ProductDTO> productDTOs = category.getProducts()
                .stream()
                .map(prod -> new ProductDTO(prod.getId(), prod.getName(), prod.getCategory().getId()))
                .collect(Collectors.toList());

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setLineId(category.getLine().getId());
        categoryDTO.setProducts(productDTOs);

        return categoryDTO;
    }
}
