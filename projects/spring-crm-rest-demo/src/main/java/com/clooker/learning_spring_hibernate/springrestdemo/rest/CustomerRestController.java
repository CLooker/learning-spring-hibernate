package com.clooker.learning_spring_hibernate.springrestdemo.rest;

import com.clooker.learning_spring_hibernate.springrestdemo.entity.Customer;
import com.clooker.learning_spring_hibernate.springrestdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    return customerService.getCustomers();
  }

  @GetMapping("/customers/{customerId}")
  public Customer getCustomer(@PathVariable int customerId) {
    Customer customer = customerService.getCustomer(customerId);
    if (customer == null) throw new CustomerNotFoundException("no customer found for customerId " + customerId);
    return customer;
  }

  @PostMapping("/customers")
  public Customer addCustomer(@RequestBody Customer customer) {
    customer.setId(0);
    customerService.saveCustomer(customer);
    return customer;
  }

  @PutMapping("/customers")
  public Customer updateCustomer(@RequestBody Customer customer) {
    customerService.saveCustomer(customer);
    return customer;
  }

  @DeleteMapping("/customers/{customerId}")
  public String deleteCustomer(@PathVariable int customerId) {
    Customer customer = customerService.getCustomer(customerId);
    if (customer == null) throw new CustomerNotFoundException("no customer found for customerId " + customerId);
    customerService.deleteCustomer(customerId);
    return "deleted customer with customerId " + customerId;
  }

}
