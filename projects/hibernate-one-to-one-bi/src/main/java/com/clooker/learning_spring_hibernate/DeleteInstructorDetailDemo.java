package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Instructor;
import com.clooker.learning_spring_hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

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

      int id = 3;
      InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);
      System.out.println("instructorDetail: " + instructorDetail);
      System.out.println("associated instructor: " + instructorDetail.getInstructor());

      // delete instructorDetail
      // associated instructor will also be deleted due to CascadeType.ALL
      System.out.println("deleting instructorDetail");
      session.delete(instructorDetail);

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
