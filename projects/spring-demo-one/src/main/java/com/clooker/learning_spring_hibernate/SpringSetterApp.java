package com.clooker.learning_spring_hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// using Spring setter injection
public class SpringSetterApp {

  public static void main(String[] args) {
    // load Spring configuration file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    // retrieve bean from Spring container
    CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);

    // call methods on bean
    System.out.println(cricketCoach.getDailyWorkout());
    System.out.println(cricketCoach.getDailyFortune());
    System.out.println(cricketCoach.getEmailAddress());
    System.out.println(cricketCoach.getTeam());

    // close application context
    context.close();
  }
}
