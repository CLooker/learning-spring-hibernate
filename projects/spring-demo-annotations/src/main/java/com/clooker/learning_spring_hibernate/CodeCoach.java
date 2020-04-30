package com.clooker.learning_spring_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CodeCoach implements Coach {

  @Autowired
  @Qualifier("fileSystemFortuneService")
  private FortuneService fortuneService;

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }

  @Override
  public String getDailyWorkout() {
    return "Solve 5 HackerRank problems.";
  }
}
