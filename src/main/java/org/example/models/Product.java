package org.example.models;

import lombok.*;
import org.example.dto.LineDTO;
import org.example.dto.ProductDTO;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}

        if (!obj.getClass().equals(ProductDTO.class)) {return false;}

        ProductDTO productDTO = (ProductDTO) obj;
        return this.id.equals(productDTO.getId()) &&
               this.name.equals(productDTO.getName()) &&
               this.category.getId().equals(productDTO.getCategoryId());
    }

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
