package com.clooker.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class FunRestController {

  @Value("${coach.name}")
  private String coachName;

  @Value("${team.name}")
  private String teamName;

  @GetMapping("/")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/workout")
  public String workout() {
    return "Go for a run";
  }

  @GetMapping("/fortune")
  public String fortune() {
    return "You will be taken to a far off land and find meaning there...";
  }

  @GetMapping("/teaminfo")
  public String teamInfo() {
    return "Coach: " + coachName + ", " + "Team: " + teamName;
  }

}
