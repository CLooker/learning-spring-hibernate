package com.clooker.learning_spring_hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationApp {

  public static void main(String[] args) {
    // read Spring config file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // get the bean from Spring container
    Coach coach = context.getBean("codeCoach", Coach.class);

    // call methods on bean
    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyWorkout());

    // close context
    context.close();
  }
}
