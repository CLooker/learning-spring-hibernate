package com.clooker.learning_spring_hibernate.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

  @GetMapping("/hello")
  public String hello() {
    return "Hello World from Spring REST!";
  }

}
