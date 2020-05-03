package com.clooker.learning_spring_hibernate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

  // for showing HTML form
  @RequestMapping("/showForm")
  public String showForm() {
    return "helloWorldForm";
  }

  // for processing HTML form
  @RequestMapping("/processForm")
  public String processForm() {
    return "helloWorld";
  }

  // for reading form data, adding data to model
  @RequestMapping("/processForm_v2")
  public String yoMessage(HttpServletRequest req, Model model) {

    // read req parameter from HTML form
    String studentName = req.getParameter("studentName");

    // create message
    String message = "YO, " + studentName.toUpperCase() + "!";

    // add message to model
    model.addAttribute("message", message);

    return "helloWorld";
  }

  @RequestMapping("/processForm_v3")
  public String processForm_v3(
    @RequestParam("studentName") String studentName,
    Model model) {
    // create message
    String message = "YO, " + studentName.toUpperCase() + "!";

    // add message to model
    model.addAttribute("message", message);

    return "helloWorld";
  }
}
