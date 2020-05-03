package com.clooker.learning_spring_hibernate;

import java.util.LinkedHashMap;

public class Student {

  private String firstName;
  private String lastName;
  private LinkedHashMap<String, String> countries;
  private String country;
  private LinkedHashMap<String, String> favoriteLanguages;
  private String favoriteLanguage;
  private String[] operatingSystems;

  public Student() {
    countries = new LinkedHashMap<>();
    countries.put("BR", "Brazil");
    countries.put("FR", "France");
    countries.put("DE", "Germany");
    countries.put("BG", "Bulgaria");

    favoriteLanguages = new LinkedHashMap<>();
    favoriteLanguages.put("Java", "Java");
    favoriteLanguages.put("JavaScript", "JavaScript");
    favoriteLanguages.put("Clojure", "Clojure");
    favoriteLanguages.put("Perl", "Perl");
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LinkedHashMap<String, String> getCountries() {
    return countries;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public LinkedHashMap<String, String> getFavoriteLanguages() {
    return favoriteLanguages;
  }

  public String getFavoriteLanguage() {
    return favoriteLanguage;
  }

  public void setFavoriteLanguage(String favoriteLanguage) {
    this.favoriteLanguage = favoriteLanguage;
  }

  public String[] getOperatingSystems() {
    return operatingSystems;
  }

  public void setOperatingSystems(String[] operatingSystems) {
    this.operatingSystems = operatingSystems;
  }
}
