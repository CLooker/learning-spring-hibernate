package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

  public static void main(String[] args) {
    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // create 3 students
      Student student = new Student("Bonita", "Applebum", "bonita@foo.com");
      Student student2 = new Student("John", "Doe", "john@foo.com");
      Student student3 = new Student("Mary", "Public", "mary@foo.com");

      // start tx
      session.beginTransaction();

      // save students
      session.save(student);
      session.save(student2);
      session.save(student3);

      // commit tx
      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
