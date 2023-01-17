package com.example.testweb;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class Book
{
    @Id
    //@GeneratedValue // Id value will not be generated by the final user
    @Column(name = "isbn", nullable = false)
    private Integer isbn;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "publisher", length = 100)
    private String publisher;

    @Column(name = "year", length = 5)
    private String year;

    @Column(name = "author", length = 50)
    private String author;

    @Column(name = "edition")
    private Integer edition;

    @Column(name = "price")
    private Float price;

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getEdition() {
        return edition;
    }

    public void setEdition(Integer edition) {
        this.edition = edition;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public Integer getId() {
        return isbn;
    }

    public void setId(Integer id) {
        this.isbn = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear()
    {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}