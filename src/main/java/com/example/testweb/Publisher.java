package com.example.testweb;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "publisher")
public class Publisher {
    @Id
    @Column(name = "publisherid", nullable = false, length = 50)
    private String id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(mappedBy = "publisher")
    private Set<Book> books = new LinkedHashSet<>();

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}