package com.clooker.learning_spring_hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanLifecycleApp {

  public static void main(String[] args) {
    // load spring configuration file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

    // retrieve bean from Spring container
    Coach coach = context.getBean("coach", Coach.class);

    // use the bean
    System.out.println(coach.getDailyWorkout());

    // close the context
    context.close();
  }
}
