package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {

  public static void main(String[] args) {
    // read Spring config
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    // get bean from Spring context
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

    List<Account> accounts = null;

    try {
      boolean shouldThrow = true;
      accounts = accountDAO.findAccounts(shouldThrow);
    } catch (Exception e) {
      System.out.println("main program exception caught: " + e.getMessage());
    }

    System.out.println("accounts: " + accounts);

    // close Spring context
    context.close();
  }

}
