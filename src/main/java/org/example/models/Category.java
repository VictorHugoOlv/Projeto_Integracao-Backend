package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.dto.CategoryDTO;
import org.example.dto.LineDTO;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {return true;}
        if (obj == null) {return false;}

        if (!obj.getClass().equals(CategoryDTO.class)) {return false;}

        CategoryDTO categoryDTO = (CategoryDTO) obj;
        return this.id.equals(categoryDTO.getId()) &&
               this.name.equals(categoryDTO.getName()) &&
               this.line.getId().equals(categoryDTO.getLineId());
    }
}