package com.ravi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginController {
    @GetMapping
    public String hi(){
        return "Login Success";
    }

    @PostMapping
    public String hi2(){
        return "Login Success";
    }
}
