package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

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

      // delete student
      session.delete(student);

      // delete student in another way
      session.createQuery("delete from Student where id = 2").executeUpdate();

      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
