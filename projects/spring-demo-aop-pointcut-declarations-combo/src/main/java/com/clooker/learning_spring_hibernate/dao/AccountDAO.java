package com.clooker.learning_spring_hibernate.dao;

import com.clooker.learning_spring_hibernate.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

  private String name;
  private String serviceCode;

  public void addAccount(Account account, boolean isVip) {
    System.out.println(getClass() + " DOING MY DB WORK: ADDING AN ACCOUNT");
  }

  public boolean isDoingWork() {
    System.out.println(getClass() + " isDoingWork: " + true);
    return true;
  }

  public String getName() {
    System.out.println(getClass() + " getName: ");
    return name;
  }

  public void setName(String name) {
    System.out.println(getClass() + " setName: ");
    this.name = name;
  }

  public String getServiceCode() {
    System.out.println(getClass() + " getServiceCode: ");
    return serviceCode;
  }

  public void setServiceCode(String serviceCode) {
    System.out.println(getClass() + " setServiceCode: ");
    this.serviceCode = serviceCode;
  }
}
