package com.clooker.learning_spring_hibernate.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

  public void addAccount() {
    System.out.println(getClass() + ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
  }

  public void goSleep() {
    System.out.println(getClass() + ": going to sleep...");
  }

}
