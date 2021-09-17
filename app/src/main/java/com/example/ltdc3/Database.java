package com.example.ltdc3;

import java.util.ArrayList;

public class Database {
    ArrayList<User> users;

    public Database() {
        for (int i = 0; i < 10; ++i) {
            users.add(new User("user"+i+"@gmail.com", "user"+i, "last"+i, "Seminaire", "password", i));
        }
    }
}
