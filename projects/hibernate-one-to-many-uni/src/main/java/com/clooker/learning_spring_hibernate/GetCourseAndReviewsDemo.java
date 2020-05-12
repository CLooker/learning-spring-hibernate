package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Course;
import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import com.clooker.learning_spring_hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetCourseAndReviewsDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .addAnnotatedClass(Course.class)
      .addAnnotatedClass(Review.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // start tx
      session.beginTransaction();

      // get course
      int id = 10;
      Course course = session.get(Course.class, id);

      System.out.println("course: " + course);
      System.out.println("reviews: " + course.getReviews());

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