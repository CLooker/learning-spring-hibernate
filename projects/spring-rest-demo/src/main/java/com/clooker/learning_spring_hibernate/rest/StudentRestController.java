package com.clooker.learning_spring_hibernate.rest;

import com.clooker.learning_spring_hibernate.entity.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

  private List<Student> students;

  @PostConstruct
  public void loadData() {
    students = new ArrayList<>();
    students.add(new Student("Poornima", "Patel"));
    students.add(new Student("Mario", "Rossi"));
    students.add(new Student("Mary", "Smith"));
  }

  @GetMapping("/students")
  public List<Student> students() {
    return students;
  }

  @GetMapping("/students/{id}")
  public Student student(@PathVariable int id) {
    boolean hasStudent = id < students.size() && id >= 0;
    if (!hasStudent) {
      throw new StudentNotFoundException("Student id not found: " + id);
    }

    return students.get(id);
  }

}
