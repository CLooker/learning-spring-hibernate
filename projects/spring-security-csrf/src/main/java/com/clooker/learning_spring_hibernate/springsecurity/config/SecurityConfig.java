package com.clooker.learning_spring_hibernate.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // add users for in-memory auth to get started
    User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
    auth.inMemoryAuthentication()
        .withUser(userBuilder.username("john").password("test123").roles("EMPLOYEE"))
        .withUser(userBuilder.username("mary").password("test123").roles("MANAGER"))
        .withUser(userBuilder.username("susan").password("test123").roles("ADMIN"));
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().anyRequest().authenticated()
        .and()
        .formLogin().loginPage("/login").loginProcessingUrl("/auth").permitAll()
        .and()
        .logout().permitAll();
  }
}
