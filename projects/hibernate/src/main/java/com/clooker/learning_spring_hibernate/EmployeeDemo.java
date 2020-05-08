package com.clooker.learning_spring_hibernate;

import com.clooker.learning_spring_hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class EmployeeDemo {
  private static SessionFactory sessionFactory;

  public SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  public void setSessionFactory(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  public static void main(String[] args) {
    EmployeeDemo employeeDemo = new EmployeeDemo();
    SessionFactory sessionFactory = new Configuration()
      .configure()
      .addAnnotatedClass(Employee.class)
      .buildSessionFactory();
    employeeDemo.setSessionFactory(sessionFactory);
    try {
      String company = "Swisha House";
      Employee employee = new Employee("Paul", "Wall", company);
      int id = saveEmployee(employee).getId();
      Employee employeeById = getEmployeeById(id);
      System.out.println("employee with id " + id + ": " + employeeById);
      List<Employee> employeesByCompany = getEmployeesByCompany(company);
      for (Employee emp : employeesByCompany) System.out.println("employee with company " + company + ": " + emp);
      deleteEmployeeById(id);
    } finally {
      sessionFactory.close();
    }
  }

  private static Employee saveEmployee(Employee employee) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.save(employee);
    session.getTransaction().commit();
    return employee;
  }

  private static Employee getEmployeeById(int id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Employee employee = session.get(Employee.class, id);
    session.getTransaction().commit();
    return employee;
  }

  private static List<Employee> getEmployeesByCompany(String company) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    List<Employee> employees = session
      .createQuery("from Employee e where e.company = '" + company +"'")
      .getResultList();
    session.getTransaction().commit();
    return employees;
  }

  private static void deleteEmployeeById(int id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Employee employee = session.get(Employee.class, id);
    session.delete(employee);
    session.getTransaction().commit();
  }
}
