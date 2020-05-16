package com.clooker.learning_spring_hibernate.controller;

import com.clooker.learning_spring_hibernate.entity.Customer;
import com.clooker.learning_spring_hibernate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomers(Model model) {
    List<Customer> customers = customerService.getCustomers();
    model.addAttribute("customers", customers);
    return "listCustomers";
  }

  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model model) {
    Customer customer = new Customer();
    model.addAttribute("customer", customer);
    return "customerForm";
  }

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {
    customerService.saveCustomer(customer);
    return "redirect:/customer/list";
  }

  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {
    Customer customer = customerService.getCustomer(customerId);
    model.addAttribute("customer", customer);
    return "customerForm";
  }

  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int customerId) {
    customerService.deleteCustomer(customerId);
    return "redirect:/customer/list";
  }
}
