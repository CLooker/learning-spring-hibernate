package com.clooker.learning_spring_hibernate;

import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

@Component
public class FileSystemFortuneService implements FortuneService {

  private Object[] fortunes;

  public FileSystemFortuneService() {
    try {
      Path path = ResourceUtils.getFile("classpath:fortunes.txt").toPath();
      try {
        fortunes = Files.lines(path).toArray(String[]::new);
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  @Override
  public String getFortune() {
    int index = new Random().nextInt(fortunes.length);
    return fortunes[index].toString();
  }
}
