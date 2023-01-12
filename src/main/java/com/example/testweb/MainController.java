package com.example.testweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class MainController
{
    @Autowired
    FirstBusinessService firstBusinessService;

    @GetMapping("landingpage")
    public String getLandingPage()
    {
        return "landingpage";
    }

    @PostMapping("landingpage")
    public String getLandingPagePost(@RequestParam("demoData") String demoData , Model model)
    {
        //Invoke Services -- Is Empty
        firstBusinessService.save(new Book());

        //Model Generation
        model.addAttribute("demoData", demoData);

        //View Generation
        return "landingpage";
    }
}
