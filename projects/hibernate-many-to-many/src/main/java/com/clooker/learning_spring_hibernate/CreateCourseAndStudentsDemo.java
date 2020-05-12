package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentsDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .addAnnotatedClass(Course.class)
      .addAnnotatedClass(Review.class)
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start tx
      session.beginTransaction();

      // create course
      Course course = new Course("Pacman - How to Score One Million Points");

      // save course
      session.save(course);

      // create students
      Student student = new Student("John", "Doe", "john@foo.com");
      Student student2 = new Student("Mary", "Public", "mary@foo.com");

      // add students to course
      course.addStudent(student);
      course.addStudent(student2);

      // save students
      session.save(student);
      session.save(student2);

      // commit tx
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      session.close();
      sessionFactory.close();
    }
  }
}