package com.example.jeweller;

public class User {
    private String fistName;
    private String lastName;
    private String login;
    private String password;
    private String gender;
    private String job;

    public User(String fistName, String lastName, String login, String password, String gender, String job) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.gender = gender;
        this.job = job;
    }

    public User() {

    }

    public String getFistName() {
        return fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getJob() {
        return job;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
