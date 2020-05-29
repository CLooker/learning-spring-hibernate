package com.clooker.learning_spring_hibernate;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration // Spring pure Java config
@EnableAspectJAutoProxy // Spring AOP
@ComponentScan("com.clooker.learning_spring_hibernate") // recursively search for components, aspects, etc
public class Config {
}
