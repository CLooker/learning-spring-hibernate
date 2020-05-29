package com.clooker.learning_spring_hibernate.aspect;

import com.clooker.learning_spring_hibernate.Account;
import com.clooker.learning_spring_hibernate.AroundWithLoggerDemoApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class LoggingAspect {

  private Logger logger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

  @Around("execution(* com.clooker.learning_spring_hibernate.service.*.getFortune(..))")
  public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    // print out method we are advising on
    logger.info("Executing aroundGetFortune");

    // print out which method we are advising on
    String methodSignature = proceedingJoinPoint.getSignature().toShortString();
    logger.info("methodSignature: " + methodSignature);

    // get begin ts
    long start = System.currentTimeMillis();

    // execute method
    Object result;

    try {
      result = proceedingJoinPoint.proceed();
    } catch (Exception e) {
      logger.warning(e.getMessage());
      throw e;
    }

    // get end ts
    long end = System.currentTimeMillis();

    // get duration
    long duration = end - start;

    // display duration
    logger.info("duration: " + (duration / 1000.0) + " seconds");

    return result;
  }

  @After("execution(* com.clooker.learning_spring_hibernate.dao.AccountDAO.findAccounts(..))")
  public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
    logger.info("Executing afterFinallyFindAccountsAdvice");

    // print out which method we are advising on
    String methodSignature = joinPoint.getSignature().toShortString();
    logger.info("methodSignature: " + methodSignature);

    
  }

  @AfterThrowing(
    pointcut = "execution(* com.clooker.learning_spring_hibernate.dao.AccountDAO.findAccounts(..))",
    throwing = "exc"
  )
  public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Exception exc) {
    logger.info("Executing afterThrowingFindAccountsAdvice");

    // print out which method we are advising on
    String methodSignature = joinPoint.getSignature().toShortString();
    logger.info("methodSignature: " + methodSignature);

    // log the exception
    logger.info("exception: " + exc);
  }

  @Before("com.clooker.learning_spring_hibernate.aspect.AopDeclarations.forDao()")
  public void beforeDaoMethod(JoinPoint joinPoint) {
    logger.info("Executing beforeDaoMethod...");

    // display method sig
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    logger.info("methodSignature: " + methodSignature);

    // display method args
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) {
      logger.info("arg: " + arg);
      if (arg instanceof Account) {
        Account account = (Account) arg;
        logger.info("account name: " + account.getName());
        logger.info("account level: " + account.getLevel());
      }
    }
  }

  @AfterReturning(
    pointcut = "execution(* com.clooker.learning_spring_hibernate.dao.AccountDAO.findAccounts(..))",
    returning = "accounts"
  )
  public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> accounts) {
    logger.info("Executing afterReturningFindAccountsAdvice...");
    String method = joinPoint.getSignature().toShortString();
    logger.info("Return value of calling " + method + ": " + accounts);

    // modify return value of method call
    for (Account account : accounts) account.setName(account.getName().toUpperCase());
  }

}
