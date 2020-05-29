package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

  @Before("com.clooker.learning_spring_hibernate.aspect.AopDeclarations.forDaoButNotGetOrSet()")
  public void performApiAnalytics() {
    System.out.println("Executing performApiAnalytics...");
  }

}
