package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  // pointcut expression - predicate which is used to determine whether to run a method
  // execution(modifiers-pattern?
  //           return-type-pattern
  //           declaring-type-pattern?
  //           method-name-pattern(param-pattern)
  //           throws-pattern?)
  @Before("execution(* com.clooker.learning_spring_hibernate.dao.*.*(..))")
  public void beforeAddAccountAdvice() {
    System.out.println("Executing @Before add*(..)");
  }

}
