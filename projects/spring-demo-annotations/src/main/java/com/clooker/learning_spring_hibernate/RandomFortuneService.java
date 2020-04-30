package com.clooker.learning_spring_hibernate;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

  private String[] fortunes = {
    "Beware of the wolf in sheep's clothing.",
    "Diligence is the mother of good luck.",
    "The journey is the reward."
  };

  @Override
  public String getFortune() {
    int index = new Random().nextInt(fortunes.length);
    return fortunes[index];
  }
}
