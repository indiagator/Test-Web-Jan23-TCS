package com.example.testweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirstBusinessService
{
    @Autowired
    BookRepository bookRepository;

    void save(Book book)
    {
        bookRepository.save(book);
    }

}
