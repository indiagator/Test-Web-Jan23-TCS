package com.example.testweb;

import jakarta.persistence.*;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @Column(name = "authorid", nullable = false)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}