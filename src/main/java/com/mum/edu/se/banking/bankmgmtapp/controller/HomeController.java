package com.mum.edu.se.banking.bankmgmtapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping(value = {"/bank/home"})
    public String home(){
        return "home/index";
    }
}
