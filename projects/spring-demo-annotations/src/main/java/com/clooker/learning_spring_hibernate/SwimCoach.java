package com.clooker.learning_spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {

  @Autowired
  @Qualifier("randomFortuneService")
  private FortuneService fortuneService;

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String getDailyWorkout() {
    return "Swim 100 laps.";
  }
}
