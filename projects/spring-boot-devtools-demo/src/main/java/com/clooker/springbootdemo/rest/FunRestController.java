package com.clooker.springbootdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class FunRestController {

  @GetMapping("/")
  public String helloWorld() {
    return "Hello World";
  }

  @GetMapping("/workout")
  public String workout() {
    return "go for a run";
  }

}
