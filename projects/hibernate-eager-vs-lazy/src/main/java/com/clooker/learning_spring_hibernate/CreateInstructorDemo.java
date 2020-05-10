package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Course;
import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {

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
      Instructor instructor = new Instructor("Susan", "Public", "bar@foo.com");

      InstructorDetail instructorDetail = new InstructorDetail(
        "https://www.youtube.com/",
        "video games"
      );

      // assoc instructor + instructorDetail
      instructor.setInstructorDetail(instructorDetail);

      // start tx
      session.beginTransaction();

      // save instructor
      // CascadeType.ALL means instructor + instructorDetail are persisted to DB
      // bc instructor + instructorDetail have a fk relationship
      session.save(instructor);

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