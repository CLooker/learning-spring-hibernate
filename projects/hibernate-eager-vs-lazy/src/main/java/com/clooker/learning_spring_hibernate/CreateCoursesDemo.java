package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Course;
import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesDemo {

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
      Instructor instructor = session.get(Instructor.class, id);

      Course course1 = new Course("Air Guitar - The Ultimate Guide");
      Course course2 = new Course("The Pinball Masterclass");

      instructor.addCourse(course1);
      instructor.addCourse(course2);

      session.save(course1);
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