package com.example.ltdc3;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class User {
    public String email;
    public String name;
    public String firstname;
    public String school;
    public String password;
    public int profilePic;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(int profilePic) {
        this.profilePic = profilePic;
    }

    public User(String email, String name, String firstname, String school, String password, int profilePic) {
        this.email = email;
        this.name = name;
        this.firstname = firstname;
        this.school = school;
        this.password = password;
        this.profilePic = profilePic;
    }
}
