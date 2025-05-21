package org.example.dto;

import lombok.Data;
import java.util.List;

@Data
public class CategoryDTO {
    private Long id;
    private String name;
    private Long lineId;
    private List<ProductDTO> products;
}
