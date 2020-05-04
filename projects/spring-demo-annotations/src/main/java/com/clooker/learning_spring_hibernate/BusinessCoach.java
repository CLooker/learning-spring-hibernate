package com.clooker.learning_spring_hibernate;

import org.springframework.beans.factory.annotation.Value;

public class BusinessCoach implements Coach {

  private FortuneService fortuneService;

  @Value("${foo.email}")
  private String email;

  public String getEmail() {
    return email;
  }

  public BusinessCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String getDailyWorkout() {
    return "Make 100 cold calls.";
  }
}
