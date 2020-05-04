package com.clooker.learning_spring_hibernate;

public class MotivationalFortuneService implements FortuneService {
  @Override
  public String getFortune() {
    return "TIME stands for Things I Must Earn.";
  }
}
