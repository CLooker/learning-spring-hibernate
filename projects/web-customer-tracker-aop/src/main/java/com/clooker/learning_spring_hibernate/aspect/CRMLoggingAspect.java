package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {

  // setup logger
  private Logger logger = Logger.getLogger(getClass().getName());

  // setup point declarations
  @Pointcut("execution(* com.clooker.learning_spring_hibernate.controller.*.*(..))")
  private void forController() {}

  @Pointcut("execution(* com.clooker.learning_spring_hibernate.service.*.*(..))")
  private void forService() {}

  @Pointcut("execution(* com.clooker.learning_spring_hibernate.dao.*.*(..))")
  private void forDao() {}

  @Pointcut("forController() || forService() || forDao()")
  private void forAppFlow() {}

  // add @Before advice
  @Before("forAppFlow()")
  public void before(JoinPoint joinPoint) {
    // display method
    String method = joinPoint.getSignature().toShortString();
    logger.info("=====>> in @Before: method: " + method);

    // display args
    Object[] args = joinPoint.getArgs();
    for (Object arg : args) logger.info("=====>> in @Before: arg: " + arg);

  }

  // add @AfterReturning advice
  @AfterReturning(
    pointcut = "forAppFlow()",
    returning = "result"
  )
  public void afterReturning(JoinPoint joinPoint, Object result) {
    // display method we are returning from
    String method = joinPoint.getSignature().toShortString();
    logger.info("=====>> in @AfterReturning: method: " + method);

    // display result
    logger.info("=====>> in @AfterReturning: result: " + result);
  }

}
