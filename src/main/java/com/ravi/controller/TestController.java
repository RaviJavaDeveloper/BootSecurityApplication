package com.ravi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String unsecuredHello(){
        return "Hello!Good Morning. This is unsecured page.";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/secure/hello")
    public String securedHello(){
        return "Hello!Good Morning. This is secured page.";
    }
}
