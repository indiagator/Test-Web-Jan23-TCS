package com.example.testweb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secondary")
public class SecondaryController
{
    @GetMapping("secondarypage")
    public String getSecPage()
    {
        return "secondarypage";
    }
}
