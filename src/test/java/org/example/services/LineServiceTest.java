package org.example.services;

import org.example.dto.LineDTO;
import org.example.models.Line;
import org.example.repositories.LineRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(MockitoExtension.class)
class LineServiceTest {

    @Mock
    private LineRepository lineRepository;

    @InjectMocks
    private LineService lineService;

    @Test
    void getAllAssertedLines() {
        List<Line> linesList = new ArrayList<>();
        linesList.add(Line.builder().id(1L).name("line1").build());
        linesList.add(Line.builder().id(2L).name("line2").build());

        when(lineRepository.findAll()).thenReturn(linesList);
        List<LineDTO> resultList = lineService.getAllLines();
        verify(lineRepository, times(1)).findAll();

        assertEquals("Compare if the number of Mocked Categories is the same as the Service list",
                linesList.size(), resultList.size());
    }
}
