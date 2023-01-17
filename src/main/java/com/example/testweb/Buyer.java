package com.example.testweb;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "buyers")
public class Buyer {
    @Id
    @Column(name = "buyerid", nullable = false, length = 50)
    private String id;

    @Column(name = "\"full name\"", length = 50)
    private String fullName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @OneToMany(mappedBy = "buyerid")
    private Set<Review> reviews = new LinkedHashSet<>();

    @OneToMany(mappedBy = "buyerid")
    private Set<Order> orders = new LinkedHashSet<>();

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}