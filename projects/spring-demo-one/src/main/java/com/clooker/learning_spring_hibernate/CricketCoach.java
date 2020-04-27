package com.clooker.learning_spring_hibernate;

public class CricketCoach implements Coach {
  private String emailAddress;
  private String team;
  private FortuneService fortuneService;

  public String getEmailAddress() {
    return emailAddress;
  }

  public String getTeam() {
    return team;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public void setTeam(String team) {
    this.team = team;
  }

  public void setFortuneService(FortuneService fortuneService) {
    this.fortuneService = fortuneService;
  }

  public CricketCoach() {}

  @Override
  public String getDailyWorkout() {
    return "Practice fast bowling for 15 minutes.";
  }

  @Override
  public String getDailyFortune() {
    return fortuneService.getFortune();
  }
}
