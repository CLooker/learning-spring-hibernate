package com.clooker.learning_spring_hibernate.service;

import com.clooker.learning_spring_hibernate.entity.Customer;

import java.util.List;

public interface CustomerService {

  List<Customer> getCustomers();

  void saveCustomer(Customer customer);

  Customer getCustomer(int customerId);

  void deleteCustomer(int customerId);
}
