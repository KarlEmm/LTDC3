package com.example.ltdc3;

public class User {
    public String email;
    public String name;
    public String firstname;
    public String school;
    public String password;
    public int imageId;

    public User(String email, String name, String firstname, String school, String password, int imageId) {
        this.email = email;
        this.name = name;
        this.firstname = firstname;
        this.school = school;
        this.password = password;
        this.imageId = imageId;
    }
}
