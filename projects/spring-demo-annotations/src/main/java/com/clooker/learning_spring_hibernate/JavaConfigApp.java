package com.clooker.learning_spring_hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigApp {

  public static void main(String[] args) {
    // read Spring config from Java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

    // get the bean from Spring container
    Coach coach = context.getBean("codeCoach", Coach.class);

    // call methods on bean
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyWorkout());

    // close context
    context.close();
  }
}
