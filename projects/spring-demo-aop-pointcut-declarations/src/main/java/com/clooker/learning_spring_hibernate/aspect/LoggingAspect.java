package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  // pointcut declaration - reusable predicate which is used to determine whether to run a method
  // execution(modifiers-pattern?
  //           return-type-pattern
  //           declaring-type-pattern?
  //           method-name-pattern(param-pattern)
  //           throws-pattern?)
  @Pointcut("execution(* com.clooker.learning_spring_hibernate.dao.*.*(..))")
  private void forDAO() {}

  @Before("forDAO()")
  public void beforeDAOMethod() {
    System.out.println("Executing @Before beforeDAOMethod");
  }

  @Before("forDAO()")
  public void performApiAnalytics() {
    System.out.println("Executing performApiAnalytics...");
  }

}
