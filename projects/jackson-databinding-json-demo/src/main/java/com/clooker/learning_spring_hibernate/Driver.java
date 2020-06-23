package com.clooker.learning_spring_hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class Driver {

  public static void main(String[] args) {
    try {
      // create obj mapper
      ObjectMapper objectMapper = new ObjectMapper();

      // read JSON from file and map to Java POJO
      Student student = objectMapper.readValue(new File("src/main/resources/sample-full.json"), Student.class);

      System.out.println("student: " + student);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
