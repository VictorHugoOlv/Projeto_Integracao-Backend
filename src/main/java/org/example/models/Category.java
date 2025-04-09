package org.example.models;

import javax.persistence.*;

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

    @Override
    public String toString(){
        return this.name;
    }

    public Long getCategoryId() {
        return id;
    }

    public String getCategoryName() {
        return name;
    }

    public Line getLine() {
        return line;
    }
}