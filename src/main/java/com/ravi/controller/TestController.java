package com.ravi.controller;

import com.ravi.services.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       List<String> roles = authentication.getAuthorities().stream()
               .map(GrantedAuthority::getAuthority)
               .collect(Collectors.toList());
      CustomUserDetails principal = (CustomUserDetails) authentication.getPrincipal();
        return "Hello "+principal.getUsername()+"!Good Morning. This is secured page. And you have roles : "+ convertListToString(roles);
    }

    private String convertListToString(List<String> roles) {
        String role = "";
        for(String r : roles){
            role = role.length() > 0 ? role+ ", "+r : r;
        }
        return role;
    }


}