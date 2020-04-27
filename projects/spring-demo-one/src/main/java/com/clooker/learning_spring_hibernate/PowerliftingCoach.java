package com.clooker.learning_spring_hibernate;

public class PowerliftingCoach implements Coach {
  private FortuneService fortuneService;

  public PowerliftingCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Do 5 x 5 competition squats @RPE 6.";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}
