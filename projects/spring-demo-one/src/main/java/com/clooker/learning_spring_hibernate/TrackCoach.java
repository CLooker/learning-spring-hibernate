package com.clooker.learning_spring_hibernate;

public class TrackCoach implements Coach {
  private FortuneService fortuneService;

  public TrackCoach(){}

  public TrackCoach(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  @Override
  public String getDailyWorkout() {
    return "Run a hard 5k";
  }

  @Override
  public String getDailyFortune() {
    return "Just Do It! " + fortuneService.getFortune();
  }

  // add an init method
  public void onInit() {
    System.out.println("TrackCoach onInit...");
  }

  // add a destroy method
  public void onDestroy() {
    System.out.println("TrackCoach onDestroy...");
  }
}
