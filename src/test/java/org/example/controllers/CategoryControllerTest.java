package org.example.controllers;

import org.example.services.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    @DisplayName("Conseguir pegar todas as categorias e produtos de Cronos")
    void getCategoriesByLineTest() {
        categoryController.getCategoriesByLine(1L);

        verify(categoryService, times(1)).getCategoriesByLine(1L);
    }
}