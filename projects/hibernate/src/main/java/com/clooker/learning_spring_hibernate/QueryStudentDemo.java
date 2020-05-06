package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Student.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start tx
      session.beginTransaction();

      // query students
      List<Student> students = session.createQuery("from Student").getResultList();

      // display students
      displayStudents(students, "student: ");

      // query students where lastName = 'Doe'
      students = session.createQuery("from Student s where s.lastName = 'Doe'").getResultList();

      // display students
      displayStudents(students, "student with lastName 'Doe': ");

      // query students where lastName = 'Doe' OR firstName = 'Daffy'
      students = session
        .createQuery("from Student s where s.lastName = 'Doe' OR s.firstName = 'George'")
        .getResultList();

      // display students
      displayStudents(students, "student with lastName 'Doe' or firstName 'George': ");

      // query students where email LIKE '%pres'
      students = session.createQuery("from Student s where s.email LIKE '%presidents.com'").getResultList();

      // display students
      displayStudents(students, "student with email LIKE '%presidents.com': ");

      // commit tx
      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }

  private static void displayStudents(List<Student> students, String s) {
    for (Student student : students) {
      System.out.println(s + student);
    }
  }
}
