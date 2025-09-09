package com.testdemo.eazy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @GetMapping("/myAccount")
    public String myAccountDetail() {
        return "myAccount detail";
    }
}
