package com.clooker.learning_spring_hibernate.springsecurity.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.clooker.learning_spring_hibernate.springsecurity")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig {

  private Logger logger = Logger.getLogger(getClass().getName());

  // set up variable to hold the properties
  @Autowired
  private Environment env;

  // define bean for ViewResolver
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
    internalResourceViewResolver.setPrefix("/WEB-INF/view/");
    internalResourceViewResolver.setSuffix(".jsp");
    return internalResourceViewResolver;
  }

  // define bean for security datasource
  @Bean
  public DataSource securityDataSource() {
    // create connection pool
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();

    // set jdbc driver class
    try {
      comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver"));
    } catch (PropertyVetoException e) {
      throw new RuntimeException(e);
    }

    // log connection properties
    logger.info(">>> jdbc.url: " + env.getProperty("jdbc.url"));
    logger.info(">>> jdbc.user: " + env.getProperty("jdbc.user"));

    // setup db connection properties
    comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
    comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
    comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));

    // setup connection pool properties
    comboPooledDataSource.setInitialPoolSize(envPropertyToInt("connection.pool.initialPoolSize"));
    comboPooledDataSource.setMinPoolSize(envPropertyToInt("connection.pool.minPoolSize"));
    comboPooledDataSource.setMaxPoolSize(envPropertyToInt("connection.pool.maxPoolSize"));
    comboPooledDataSource.setMaxIdleTime(envPropertyToInt("connection.pool.maxIdleTime"));

    return comboPooledDataSource;
  }

  // helper for reading env property and cast to int
  private int envPropertyToInt(String envProperty) {
    return Integer.parseInt(env.getProperty(envProperty));
  }

}
