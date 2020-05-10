package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Course;
import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .addAnnotatedClass(Course.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start tx
      session.beginTransaction();

      int id = 1;
      Query<Instructor> query = session.createQuery(
        "SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id = :instructorId",
        Instructor.class
      );

      query.setParameter("instructorId", id);
      Instructor instructor = query.getSingleResult();

      System.out.println("instructor: " + instructor);

      // commit tx
      session.getTransaction().commit();
      session.close();

      System.out.println("courses: " + instructor.getCourses());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sessionFactory.close();
    }
  }
}