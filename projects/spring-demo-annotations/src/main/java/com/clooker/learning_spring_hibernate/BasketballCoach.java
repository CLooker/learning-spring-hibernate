package com.clooker.learning_spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

  private FortuneService fortuneService;

  @Autowired
  @Qualifier("happyFortuneService")
  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String getDailyWorkout() {
    return "Do the Mikan drill until you make 50 in a row.";
  }
}
