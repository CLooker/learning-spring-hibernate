package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;

public class DeleteDemo {

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
      // start tx
      session.beginTransaction();

      // get instructor by primary key
      int id = 1;

      Instructor instructor = session.get(Instructor.class, id);

      // delete instructor
      if (instructor != null) {
        System.out.println("Deleting instructor: " + instructor);

        // will also delete associated instructorDetail bc of CascadeType.ALL
        session.delete(instructor);
      }

      // commit tx
      session.getTransaction().commit();
    } finally {
      sessionFactory.close();
    }
  }
}
