package com.clooker.learning_spring_hibernate.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String getHome() {
    return "home";
  }

  @GetMapping("/leaders")
  public String getLeaders() {
    return "leaders";
  }

  @GetMapping("/systems")
  public String getSystems() {
    return "systems";
  }

}
