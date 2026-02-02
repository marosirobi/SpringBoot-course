package com.springboot.demo.entity;


import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLang;
    private List<String> favoriteSystems;

    public Student() {
    }

    public String getFavoriteLang() {
        return favoriteLang;
    }

    public List<String> getFavoriteSystems() {
        return favoriteSystems;
    }

    public void setFavoriteSystems(List<String> favoriteSystems) {
        this.favoriteSystems = favoriteSystems;
    }

    public void setFavoriteLang(String favoriteLang) {
        this.favoriteLang = favoriteLang;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
