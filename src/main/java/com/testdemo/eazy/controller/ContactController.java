package com.testdemo.eazy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public String myAccountDetail() {
        return "Contact detail";
    }
}
