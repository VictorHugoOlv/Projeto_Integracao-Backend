package org.example.models;

import javax.persistence.*;

@Entity
@Table(name = "line")
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
