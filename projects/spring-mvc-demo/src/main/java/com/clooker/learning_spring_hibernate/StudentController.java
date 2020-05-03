package com.clooker.learning_spring_hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

  @RequestMapping("/showForm")
  public String showForm(Model model) {

    // create new student
    Student student = new Student();

    // add student to model
    model.addAttribute("student", student);

    return "studentForm";
  }

  @RequestMapping("/processForm")
  public String processForm(
    @ModelAttribute("student") Student student
  ) {
    return "studentConfirmation";
  }
}
