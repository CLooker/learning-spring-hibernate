package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

  @Before("com.clooker.learning_spring_hibernate.aspect.AopDeclarations.forDao()")
  public void beforeDaoMethod() {
    System.out.println("Executing beforeDaoMethod...");
  }

}
