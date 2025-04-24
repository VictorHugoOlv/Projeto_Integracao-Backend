package org.example.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "line", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Category> categories;

    @Override
    public String toString() {
        return name;
    }

    public Line() {}

    public Line(String name) {
        this.name = name;
    }

    public int getLineId() {
        return id;
    }

    public String getLineName() {
        return name;
    }

    public Set<Category> getCategories() {
        return categories;
    }

}
