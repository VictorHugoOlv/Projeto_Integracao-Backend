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

    @Override
    public String toString(){
        return this.name;
    }

    public Line() {}

    public Long getLineId() {
        return id;
    }

    public String getLineName() {
        return name;
    }

}
