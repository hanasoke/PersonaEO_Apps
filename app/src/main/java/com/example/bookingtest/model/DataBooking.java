package com.example.bookingtest.model;

public class DataBooking {
    String company, date, email, loc, message, name, people, status;

    public DataBooking(){}

    public DataBooking(String name, String company, String email, String loc, String people, String date, String status, String message) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.loc = loc;
        this.people = people;
        this.date = date;
        this.status = status;
        this.message = message;
    }

    public DataBooking(String name, String company, String email, String loc, String people, String date, String message) {
        this.name = name;
        this.company = company;
        this.email = email;
        this.loc = loc;
        this.people = people;
        this.date = date;
        this.message = message;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
