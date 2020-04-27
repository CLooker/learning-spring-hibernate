package com.clooker.learning_spring_hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// using Spring constructor injection
public class SpringConstructorApp {

  public static void main(String[] args) {
    // load spring config
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from spring container
    Coach coach = context.getBean("coach", Coach.class);

    // call methods on bean
    System.out.println(coach.getDailyWorkout());
    System.out.println(coach.getDailyFortune());

    // close application context
    context.close();
  }
}
