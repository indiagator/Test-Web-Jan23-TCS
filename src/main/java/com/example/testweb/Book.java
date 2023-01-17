package com.example.testweb;

import jakarta.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.springframework.context.annotation.Lazy;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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

    @OneToMany(mappedBy = "isbn")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "isbn")
    private Set<Order> orders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "isbn")
    private Set<Tag> tags = new LinkedHashSet<>();

    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (!Objects.equals(isbn, book.isbn)) return false;
        if (!Objects.equals(name, book.name)) return false;
        if (!Objects.equals(publisher, book.publisher)) return false;
        if (!Objects.equals(year, book.year)) return false;
        if (!Objects.equals(author, book.author)) return false;
        if (!Objects.equals(edition, book.edition)) return false;
        return Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        int result = isbn != null ? isbn.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (publisher != null ? publisher.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (edition != null ? edition.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", author='" + author + '\'' +
                ", edition=" + edition +
                ", price=" + price +
                '}';
    }
}