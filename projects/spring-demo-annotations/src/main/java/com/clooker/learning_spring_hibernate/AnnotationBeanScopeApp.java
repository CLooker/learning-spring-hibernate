package com.clooker.learning_spring_hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeApp {

  public static void main(String[] args) {
    // load Spring config file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from Spring container
    Coach coach = context.getBean("codeCoach", Coach.class);

    System.out.println(coach.getDailyFortune());
    System.out.println(coach.getDailyWorkout());

    // close context
    context.close();
  }
}
