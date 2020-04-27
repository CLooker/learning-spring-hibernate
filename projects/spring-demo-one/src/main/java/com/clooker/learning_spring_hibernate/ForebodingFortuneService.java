package com.clooker.learning_spring_hibernate;

import java.util.Random;

public class ForebodingFortuneService implements FortuneService {
  String[] fortunes = {
    "Something wicked comes your way.",
    "Be afraid. Be very afraid.",
    "Double, double toil and trouble. Fire burn and cauldron bubble."
  };

  @Override
  public String getFortune() {
    int index = new Random().nextInt(fortunes.length);
    return fortunes[index];
  }
}
