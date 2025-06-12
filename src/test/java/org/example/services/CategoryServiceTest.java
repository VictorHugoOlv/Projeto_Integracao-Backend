package org.example.services;

import org.example.dto.CategoryDTO;
import org.example.models.Category;
import org.example.models.Line;
import org.example.models.Product;
import org.example.repositories.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

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
        assertEquals("Compare if the number of Mocked Categories is the same as the Service list",
                mockCategories.size(), resultList.size());
        assertEquals("Verify if the size of Service list is the same as the Mocked list",
                1, resultList.size());

        CategoryDTO dto = resultList.get(0);

        assertEquals("Verify if the Categories Id´s are being preserved",
                category.getId(), dto.getId());
        assertEquals("Verify if the Categories Names are being preserved",
                category.getName(), dto.getName());
        assertEquals("Verify if the Line Id is being preserved",
                lineId, dto.getLineId());
        assertEquals("Verify if the size of Service Product list is the same as the Mocked list",
                3, dto.getProducts().size());
        assertEquals("Verify the integrity of Product Id´s and their order",
                100L, dto.getProducts().get(0).getId());
        assertEquals("Verify the integrity of Product Names and their order",
                "product1", dto.getProducts().get(0).getName());
    }
}