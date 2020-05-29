package com.clooker.learning_spring_hibernate.aspect;

import com.clooker.learning_spring_hibernate.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

  @AfterThrowing(
    pointcut = "execution(* com.clooker.learning_spring_hibernate.dao.AccountDAO.findAccounts(..))",
    throwing = "exc"
  )
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception exc) {
    System.out.println("Executing afterThrowingFindAccountsAdvice");

    // print out which method we are advising on
    String methodSignature = joinPoint.getSignature().toShortString();
    System.out.println("methodSignature: " + methodSignature);

    // log the exception
    System.out.println("exception: " + exc);
  }

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

  @AfterReturning(
    pointcut = "execution(* com.clooker.learning_spring_hibernate.dao.AccountDAO.findAccounts(..))",
    returning = "accounts"
  )
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
    System.out.println("Executing afterReturningFindAccountsAdvice...");
    String method = joinPoint.getSignature().toShortString();
    System.out.println("Return value of calling " + method + ": " + accounts);

    // modify return value of method call
    for (Account account : accounts) account.setName(account.getName().toUpperCase());
  }

}
