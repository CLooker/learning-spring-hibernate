package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

  public static void main(String[] args) {

    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    Session session = sessionFactory.getCurrentSession();

    try {
      int studentId = 1;

      session.beginTransaction();

      Student student = session.get(Student.class, studentId);

      // update entity in memory
      student.setFirstName("Scooby");

      // persist update in db
      session.getTransaction().commit();

      session = sessionFactory.getCurrentSession();

      session.beginTransaction();

      // update email for all students
      session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();

      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
