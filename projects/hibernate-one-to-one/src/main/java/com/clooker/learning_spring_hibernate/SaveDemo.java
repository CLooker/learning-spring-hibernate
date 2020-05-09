package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SaveDemo {

  public static void main(String[] args) {

    // create session factory
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Instructor.class)
      .addAnnotatedClass(InstructorDetail.class)
      .buildSessionFactory();

    // create session
    Session session = sessionFactory.getCurrentSession();

    try {
      // create instructor + instructorDetail
//      Instructor instructor = new Instructor("Chad", "Looker", "foo@foo.com");
      Instructor instructor = new Instructor("Bilyana", "Looker", "bar@foo.com");

//      InstructorDetail instructorDetail = new InstructorDetail(
//        "https://www.youtube.com/user/ClojureTV",
//        "Clojure"
//      );
      InstructorDetail instructorDetail = new InstructorDetail(
        "https://www.youtube.com/channel/UCexNn7c7IhTrXd943DK3N0g",
        "sewing"
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
    } finally {
      sessionFactory.close();
    }
  }
}
