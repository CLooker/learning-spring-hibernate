package com.clooker.learning_spring_hibernate;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  @RequestMapping("/showForm")
  public String showForm(Model model) {
    model.addAttribute("customer", new Customer());
    return "customerForm";
  }

  @RequestMapping("/processForm")
  public String processForm(
    @Valid
    @ModelAttribute("customer") Customer customer,
    BindingResult bindingResult
  ) {
    return bindingResult.hasErrors()
      ? "customerForm"
      : "customerConfirmation";
  }
}
