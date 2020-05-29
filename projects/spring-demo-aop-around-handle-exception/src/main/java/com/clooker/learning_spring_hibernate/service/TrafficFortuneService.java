package com.clooker.learning_spring_hibernate.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneService {

  public String getFortune() {
    // simulate a delay
    try {
      TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // return a fortune
    return "Expect heavy traffic this morning.";
  }

  public String getFortune(boolean shouldThrow) {
    if (shouldThrow) {
      throw new RuntimeException("Major Accident! Highway closed!");
    }

    return getFortune();
  }
}
