package com.example.testweb;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@SessionAttributes("username")
@Controller
public class MainController
{
    @Autowired
    FirstBusinessService firstBusinessService;

    @GetMapping("/landingpage")
    public String getLandingPage(RedirectAttributes redirectAttributes)
    {
        //redirectAttributes.addAttribute();
        return "redirect:/secondary/secondarypage";
    }

    @PostMapping("/landingpage")
    @ModelAttribute("book")
    public Book getLandingPagePost(@RequestParam("demoData") @SessionAttribute String demoData , Model model, HttpServletRequest request, HttpSession session, RedirectAttributes redirectAttributes) // Model bean is automatically injected when you use it as a parameter
    {
        //Invoke Services -- Is Empty
        firstBusinessService.save(new Book());

        request.getParameter("demoData");

        request.getSession(false);

        //Model Generation
        model.addAttribute("demoData", demoData);
        //model.addAttribute("username",username);
        //session.setAttribute("username",username);
        //View Generation

        Book book = new Book();
        book.setId(Integer.valueOf("777"));
        return book;
    }


    @ModelAttribute // Acts like a Filter
    public Book addAttribute()
    {
        return new Book();
    }

}
