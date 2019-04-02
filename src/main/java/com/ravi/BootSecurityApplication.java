package com.ravi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;

@SpringBootApplication
public class BootSecurityApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootSecurityApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootSecurityApplication.class, args);
    }

    //To remove default role prefix for spring security
    @Bean
    public GrantedAuthorityDefaults grantedAuthorityDefaults(){
        return new GrantedAuthorityDefaults("");
    }
}
