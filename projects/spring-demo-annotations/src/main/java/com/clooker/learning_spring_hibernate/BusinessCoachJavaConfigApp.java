package com.clooker.learning_spring_hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BusinessCoachJavaConfigApp {

  public static void main(String[] args) {
    // read Spring config from Java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BusinessConfig.class);

    // get the bean from Spring container
    BusinessCoach coach = context.getBean("businessCoach", BusinessCoach.class);

    // call methods on bean
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getEmail());

    // close context
    context.close();
  }
}
