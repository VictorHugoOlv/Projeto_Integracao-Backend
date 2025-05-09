package org.example.controllers;

import org.example.dto.ProductDTO;
import org.example.models.Category;
import org.example.models.Product;
import org.example.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<ProductDTO> getProductsByCategory(Category category) {
        return productRepository.findByCategoryId(category.getId()).stream().map(this::productDTO).collect(Collectors.toList());
    }

    private ProductDTO productDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCategoryId(product.getCategory().getId());
        return productDTO;
    }
}
