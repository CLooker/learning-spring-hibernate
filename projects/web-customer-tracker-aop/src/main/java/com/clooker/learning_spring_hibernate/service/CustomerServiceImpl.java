package com.clooker.learning_spring_hibernate.service;

import com.clooker.learning_spring_hibernate.dao.CustomerDAO;
import com.clooker.learning_spring_hibernate.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  private CustomerDAO customerDAO;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    return customerDAO.getCustomers();
  }

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    customerDAO.saveCustomer(customer);
  }

  @Override
  @Transactional
  public Customer getCustomer(int customerId) {
    return customerDAO.getCustomer(customerId);
  }

  @Override
  @Transactional
  public void deleteCustomer(int customerId) {
    customerDAO.deleteCustomer(customerId);
  }

}
