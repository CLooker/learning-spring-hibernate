package com.clooker.learning_spring_hibernate.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopDeclarations {

  // pointcut declaration - reusable predicate which is used to determine whether to run a method
  // execution(modifiers-pattern?
  //           return-type-pattern
  //           declaring-type-pattern?
  //           method-name-pattern(param-pattern)
  //           throws-pattern?)
  @Pointcut("execution(* com.clooker.learning_spring_hibernate.dao.*.*(..))")
  public void forDao() {}

  @Pointcut("execution(* com.clooker.learning_spring_hibernate.dao.*.get*(..))")
  public void forDaoGet() {}

  @Pointcut("execution(* com.clooker.learning_spring_hibernate.dao.*.set*(..))")
  public void forDaoSet() {}

  @Pointcut("forDao() && !(forDaoGet() || forDaoSet())")
  public void forDaoButNotGetOrSet() {}
  
}
