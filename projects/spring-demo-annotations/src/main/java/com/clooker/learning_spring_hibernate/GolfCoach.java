package com.clooker.learning_spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GolfCoach implements Coach {

  @Autowired
  @Qualifier("happyFortuneService")
  private FortuneService fortuneService;

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String getDailyWorkout() {
    return "Hit the green 20 times using your sand wedge from a greenside bunker.";
  }
}
