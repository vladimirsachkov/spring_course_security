package com.zaurtregulov.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import static org.springframework.security.core.userdetails.User.*;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("zaur").
                        password("zaur")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder.username("elena")
                        .password("elena")
                        .roles("HR"))
                .withUser(userBuilder.username("ivan")
                        .password("ivan")
                        .roles("MANAGER", "HR"));
    }
}
