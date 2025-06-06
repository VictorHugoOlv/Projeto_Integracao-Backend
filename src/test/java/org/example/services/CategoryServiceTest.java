package org.example.services;

import org.example.dto.CategoryDTO;
import org.example.models.Category;
import org.example.models.Line;
import org.example.models.Product;
import org.example.repositories.CategoryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void getCategoriesAndProducts() {
        Long lineId = 1L;
        Line line = Line.builder().id(lineId).name("line1").build();

        Category category = Category.builder()
                .id(10L)
                .name("category1")
                .line(line)
                .products(Arrays.asList(
                        Product.builder().id(100L).name("product1").category(null).build(),
                        Product.builder().id(101L).name("product2").category(null).build(),
                        Product.builder().id(102L).name("product3").category(null).build()
                ))
                .build();

        category.getProducts().forEach(product -> product.setCategory(category));
        List<Category> mockCategories = Arrays.asList(category);

        when(categoryRepository.findByLineId(lineId)).thenReturn(mockCategories);

        List<CategoryDTO> resultList = categoryService.getCategoriesByLine(lineId);

        verify(categoryRepository, times(1)).findByLineId(lineId);

        Assertions.assertEquals(mockCategories.size(), resultList.size());
        Assertions.assertEquals(1, resultList.size());
        CategoryDTO dto = resultList.get(0);
        Assertions.assertEquals(category.getId(), dto.getId());
        Assertions.assertEquals(category.getName(), dto.getName());
        Assertions.assertEquals(lineId, dto.getLineId());
        Assertions.assertEquals(3, dto.getProducts().size());
        Assertions.assertEquals(100L, dto.getProducts().get(0).getId());
        Assertions.assertEquals("product1", dto.getProducts().get(0).getName());
    }
}