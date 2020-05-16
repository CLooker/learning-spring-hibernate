package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.dao.AccountDAO;
import com.clooker.learning_spring_hibernate.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

  public static void main(String[] args) {
    // read Spring config
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

    // get bean from Spring context
    AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
    MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);


    // call business method
    Account account = new Account();
    accountDAO.addAccount(account, true);
    accountDAO.isDoingWork();
    membershipDAO.addAccount();
    membershipDAO.goSleep();

    // close Spring context
    context.close();
  }

}
