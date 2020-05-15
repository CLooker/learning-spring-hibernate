package com.clooker.learning_spring_hibernate.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException {
    // setup connection variables
    String user = "hbstudent";
    String pass = user;
    String jdbcUrl =
      "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    String driver = "com.mysql.jdbc.Driver";

    // get connection to db
    try {
      PrintWriter out = res.getWriter();
      out.println("Connecting to db: " + jdbcUrl);
      Class.forName(driver);
      Connection connection = DriverManager.getConnection(jdbcUrl, user, pass);
      out.println("Connection to db successful");
      connection.close();
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }
  }
}
