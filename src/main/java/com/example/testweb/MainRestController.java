package com.example.testweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.1")
public class MainRestController
{

    @Autowired
    BookRepository bookRepository;

    @GetMapping("book/{id}")
    Book getBook(@PathVariable("id") String id)
    {
       return bookRepository.findById(Integer.valueOf(id)).get(); // Converted to JSON
    }

    @PostMapping("sendbody")
    Book getBody(@RequestBody User user )
    {
        Book book = new Book();
        book.setId(Integer.valueOf(user.getAge()));
        return book;
    }

    @PostMapping("savebook")
    StatusMessage saveBook(@RequestBody Book book)
    {
        bookRepository.save(book);
        StatusMessage msg = new StatusMessage();
        msg.setMessage("New Book Saved");
        return msg;
    }

}
