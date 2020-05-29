package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundWithLoggerDemoApp {
  
  private static Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

  public static void main(String[] args) {
    // read Spring config
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    TrafficFortuneService trafficFortuneService =
      context.getBean("trafficFortuneService", TrafficFortuneService.class);

    logger.info("Main program: AroundDemoApp");

    String fortune = trafficFortuneService.getFortune();

    logger.info("fortune: " + fortune);

    logger.info("finished");

    // close Spring context
    context.close();
  }

}
