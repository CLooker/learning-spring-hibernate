package com.clooker.learning_spring_hibernate;

public class App {

  public static void main(String[] args) {
    Coach coach = new TrackCoach();
    System.out.println(coach.getDailyWorkout());
  }
}
