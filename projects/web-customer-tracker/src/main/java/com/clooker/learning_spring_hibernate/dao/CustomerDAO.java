package com.clooker.learning_spring_hibernate.dao;

import com.clooker.learning_spring_hibernate.entity.Customer;

import java.util.List;

public interface CustomerDAO {

  List<Customer> getCustomers();

  void saveCustomer(Customer customer);

  Customer getCustomer(int customerId);

  void deleteCustomer(int customerId);
}
