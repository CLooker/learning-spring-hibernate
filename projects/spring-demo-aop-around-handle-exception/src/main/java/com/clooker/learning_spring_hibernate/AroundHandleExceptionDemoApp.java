package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
  
  private static Logger logger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

  public static void main(String[] args) {
    // read Spring config
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    TrafficFortuneService trafficFortuneService =
      context.getBean("trafficFortuneService", TrafficFortuneService.class);

    logger.info("Main program: AroundDemoApp");

    logger.info("Calling getFortune");

    boolean shouldThrow = true;

    String fortune = trafficFortuneService.getFortune(shouldThrow);

    logger.info("fortune: " + fortune);

    logger.info("finished");

    // close Spring context
    context.close();
  }

}
