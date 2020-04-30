package com.clooker.learning_spring_hibernate;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.stream.Stream;

@Component
public class FileSystemFortuneService implements FortuneService {

  private String[] fortunes;

  public FileSystemFortuneService() {
    // read json file
  }

  @Override
  public String getFortune() {
    int index = new Random().nextInt(fortunes.length);
    return fortunes[index].toString();
  }
}
