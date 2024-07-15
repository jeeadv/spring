package com.example.demo.demo.security;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
public class SecurityConfiguration //extends WebSecurityConfigurerAdapter
{
    //AuthManagerBuilder.inMemoryAuth().withUser().password().roles()

    //HttpSecurity.basic().authorizeRequest().matchers("/questions/**").hasRole("Admin")
    // .request().authenticated()
}
