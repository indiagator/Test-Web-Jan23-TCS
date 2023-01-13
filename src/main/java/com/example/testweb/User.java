package com.example.testweb;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User
{
    private String name;
    private int age;
    private String city;
}
