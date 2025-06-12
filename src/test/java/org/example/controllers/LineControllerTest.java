package org.example.controllers;

import org.example.services.LineService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LineControllerTest {

    @Mock
    private LineService lineService;

    @InjectMocks
    private LineController lineController;

    @Test
    void getLinesTest() {
        lineController.getAllLines();

        verify(lineService, times(1)).getAllLines();
    }
}
