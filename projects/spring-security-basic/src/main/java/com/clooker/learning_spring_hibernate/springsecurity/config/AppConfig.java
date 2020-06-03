package com.clooker.learning_spring_hibernate.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.clooker.learning_spring_hibernate.springsecurity")
public class AppConfig {

  // define bean for ViewResolver
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/WEB-INF/view/");
    internalResourceViewResolver.setSuffix(".jsp");
    return internalResourceViewResolver;
  }

}
