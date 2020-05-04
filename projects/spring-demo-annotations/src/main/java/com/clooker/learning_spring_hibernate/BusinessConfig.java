package com.clooker.learning_spring_hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:business.properties")
public class BusinessConfig {

  @Bean
  public FortuneService motivationalFortuneService() {
    return new MotivationalFortuneService();
  }

  @Bean
  public Coach businessCoach() {
    return new BusinessCoach(motivationalFortuneService());
  }

}
