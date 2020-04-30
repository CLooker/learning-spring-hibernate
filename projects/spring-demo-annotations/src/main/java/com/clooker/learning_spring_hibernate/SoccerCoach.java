package com.clooker.learning_spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SoccerCoach implements Coach {

  private FortuneService fortuneService;

  // do not have to use expected setter method
  @Autowired
  @Qualifier("happyFortuneService")
  public void customSetterMethod(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String getDailyWorkout() {
    return "Practice free kicks 20 yards away from goal.";
  }
}
