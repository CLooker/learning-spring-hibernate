package com.clooker.learning_spring_hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimCoachJavaConfigApp {

  public static void main(String[] args) {
    // read Spring config from Java class
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);

    // get the bean from Spring container
    SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);

    // call methods on bean
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getEmail());
    System.out.println(coach.getTeam());

    // close context
    context.close();
  }
}
