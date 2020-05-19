package com.clooker.learning_spring_hibernate.dao;

import com.clooker.learning_spring_hibernate.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

  public void addAccount(Account account, boolean isVip) {
    System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
  }

  public boolean isDoingWork() {
    System.out.println(getClass() + " isDoingWork: " + true);
    return true;
  }

}
