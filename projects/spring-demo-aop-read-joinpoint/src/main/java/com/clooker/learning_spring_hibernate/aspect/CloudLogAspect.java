package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class CloudLogAspect {

  @Before("com.clooker.learning_spring_hibernate.aspect.AopDeclarations.forDaoButNotGetOrSet()")
  public void logToCloud() {
    System.out.println("Executing logToCloud...");
  }

}
