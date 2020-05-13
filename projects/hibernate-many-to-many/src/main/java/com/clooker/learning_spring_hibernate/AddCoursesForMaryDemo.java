package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCoursesForMaryDemo {

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

      // get mary
      int id = 2;
      Student mary = session.get(Student.class, 2);

      // create more courses
      Course course = new Course("Rubik's Cube - How to Speed Cube");
      Course course2 = new Course("Atari 2600 - Game Development");

      // add mary to those courses
      course.addStudent(mary);
      course2.addStudent(mary);

      // save courses
      session.save(course);
      session.save(course2);

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
