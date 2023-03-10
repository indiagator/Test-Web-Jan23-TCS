package com.example.testweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/1.1")
public class MainRestController
{

    @Autowired
    PublisherHbmDao publisherHbmDao;

    //@Autowired
    //BookRepository bookRepository;

   // @GetMapping("book/{id}")
   // Book getBook(@PathVariable("id") String id)
    //{
       //return bookRepository.findById(Integer.valueOf(id)).get(); // Converted to JSON
   // }

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
       // bookRepository.save(book);
        StatusMessage msg = new StatusMessage();
        msg.setMessage("New Book Saved");
        return msg;
    }

    @GetMapping("savepub")
    public void testSavePublisher()
    {
        publisherHbmDao.savePublisherTest();
    }

    @GetMapping("getpub")
    Publisher getPublisher(@RequestParam("name") String name)
    {
        return publisherHbmDao.getPublisherTest(name);
    }

    @GetMapping("updtpub")
    Publisher updatePublisher(@RequestParam("name") String name, @RequestParam("newName") String newName)
    {
        return publisherHbmDao.updatePublisherTest(name,newName);
    }

    @GetMapping("delpub")
    void  deletePublisher(@RequestParam("name") String name)
    {
        publisherHbmDao.deletePublisher(name);
    }

}
