package com.clooker.learning_spring_hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String showPage() {
    return "main-menu";
  }
}
