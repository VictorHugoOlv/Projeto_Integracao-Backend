package org.example.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "line_id", nullable = false)
    private Line line;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products;

    public Category() {
    }

    public Category(String name, Line line) {
        this.name = name;
        this.line = line;
    }

    public int getCategoryId() {
        return id;
    }

    public String getCategoryName() {
        return name;
    }

    public Line getLine() {
        return line;
    }

    public Set<Product> getProducts() {
        return products;
    }
}