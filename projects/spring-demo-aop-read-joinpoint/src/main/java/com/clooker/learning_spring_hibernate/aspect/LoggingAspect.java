package com.clooker.learning_spring_hibernate.aspect;

import com.clooker.learning_spring_hibernate.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

  @Before("com.clooker.learning_spring_hibernate.aspect.AopDeclarations.forDao()")
  public void beforeDaoMethod(JoinPoint joinPoint) {
    System.out.println("Executing beforeDaoMethod...");

    // display method sig
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    System.out.println("methodSignature: " + methodSignature);

    // display method args
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      System.out.println("arg: " + arg);
      if (arg instanceof Account) {
        Account account = (Account) arg;
        System.out.println("account name: " + account.getName());
        System.out.println("account level: " + account.getLevel());
      }
    }
  }

}
