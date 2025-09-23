package com.oauth2.social.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecureController {

    @GetMapping("/secure")
    public String secure() {
        return "secure.html";
    }

    @GetMapping("/my-login")
    public String login() {
        return "login.html";
    }
}
