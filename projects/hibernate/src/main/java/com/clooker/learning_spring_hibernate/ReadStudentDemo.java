package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // create student
      Student student = new Student("George", "Washington", "george_washington@presidents.com");

      // start tx
      session.beginTransaction();

      // save student
      session.save(student);

      // commit tx
      session.getTransaction().commit();

      // new session and tx
      session = sessionFactory.getCurrentSession();
      session.beginTransaction();

      // retrieve student based on id
      Student studentFromDb = session.get(Student.class, student.getId());
      System.out.println("studentFromDb: " + studentFromDb);

      // commit tx
      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
