package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.dao.AccountDAO;
import com.clooker.learning_spring_hibernate.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AroundDemoApp {

  public static void main(String[] args) {
    // read Spring config
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    TrafficFortuneService trafficFortuneService =
      context.getBean("trafficFortuneService", TrafficFortuneService.class);

    System.out.println("Main program: AroundDemoApp");

    String fortune = trafficFortuneService.getFortune();

    System.out.println("fortune: " + fortune);

    System.out.println("finished");

    // close Spring context
    context.close();
  }

}
