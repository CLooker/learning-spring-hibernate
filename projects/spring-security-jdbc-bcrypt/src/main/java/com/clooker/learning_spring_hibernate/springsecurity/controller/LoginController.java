package com.clooker.learning_spring_hibernate.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String getLogin() {
    return "bootstrap-login";
  }

  @GetMapping("/access-denied")
  public String getAccessedDenied() {
    return "access-denied";
  }

}
