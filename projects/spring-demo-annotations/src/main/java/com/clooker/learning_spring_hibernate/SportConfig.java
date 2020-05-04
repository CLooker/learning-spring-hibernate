package com.clooker.learning_spring_hibernate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
public class SportConfig {

  // bean for sad fortune service
  @Bean
  public FortuneService sadFortuneService() {
    return new SadFortuneService();
  }

  // bean for swim coach and inject dependency
  @Bean
  public Coach swimCoach() {
    return new SwimCoach(sadFortuneService());
  }

}
