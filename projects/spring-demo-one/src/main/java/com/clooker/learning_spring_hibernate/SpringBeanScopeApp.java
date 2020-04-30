package com.clooker.learning_spring_hibernate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanScopeApp {

  public static void main(String[] args) {
    // load spring configuration file
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

    // retrieve bean from Spring container
    Coach coach = context.getBean("coach", Coach.class);
    Coach alphaCoach = context.getBean("coach", Coach.class);

    // check if coaches are the same reference
    boolean isSameCoach = coach == alphaCoach;
    System.out.println("isSameCoach: " + isSameCoach);

    // close the context
    context.close();
  }
}
