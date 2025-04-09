package org.example.models;

import javax.persistence.*;

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
    public String toString() {
        return this.name;
    }

    public Long getProductId() {
        return id;
    }

    public String getProductName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

}
