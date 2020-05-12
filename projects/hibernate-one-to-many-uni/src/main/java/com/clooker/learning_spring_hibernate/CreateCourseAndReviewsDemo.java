package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Course;
import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import com.clooker.learning_spring_hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {

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

      // create course
      Course course = new Course("Pacman - How to Score One Million Points");

      // add reviews
      course.addReview(new Review("Great course...loved it!"));
      course.addReview(new Review("Cool course, job well done"));
      course.addReview(new Review("What a dumb course, you're an idiot!"));

      // save course (which will also save reviews bc of CascadeType.ALL
      session.save(course);

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