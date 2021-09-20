package com.example.ltdc3;

import android.app.Application;

import java.util.ArrayList;

public class Database extends Application {
    ArrayList<User> users = new ArrayList<>();
    ArrayList<FeedData> feedData = new ArrayList<>();
    int idSingleton=0;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public ArrayList<FeedData> getFeedData() {
        return feedData;
    }

    public void setFeedData(ArrayList<FeedData> feedData) {
        this.feedData = feedData;
    }

    public ArrayList<Challenge> challenges;

    public void initDB() {
        ArrayList<Comment> comments = new ArrayList<>();

        User u1 = new User("karl.bast@gmail.com", "Bastarache", "Karl-Emmanuel", "Séminaire Saint-Joseph", "password", R.drawable.teenager2, 100);
        User u2 = new User("lisa.marier@gmail.com", "Marier", "Lisa", "Séminaire Saint-Joseph", "password", R.drawable.teenager1, 200);
        User u3 = new User("john.smith@gmail.com", "John", "Smith", "Polytechnique", "password", R.drawable.teenager4, 300);
        User u4 = new User("Paul@gmail.com", "Blart", "Paul", "Harvard", "password", R.drawable.teenager3, 400);

        u1.addFriend(u2);
        u2.addFriend(u1);

        users.add(u1);
        users.add(u2);
        users.add(u3);
        users.add(u4);

        challenges = new ArrayList<>();
        challenges.add(new Challenge("Vegan roastbeef", 25, "april 12 2021"));
        challenges.add(new Challenge("Sushi", 25, "april 16 2021"));
        challenges.add(new Challenge("fish n chips", 25, "11 september 2001"));

        Comment c1 = new Comment(u2, "This looks very good! Can I have a share tomorrow? :')", 2, "1h");
        Comment c2 = new Comment(u3, "What recipe did you follow? This looks amazing.", 3, "2h");

        comments.add(c1);
        comments.add(c2);

        FeedData fd1 = new FeedData(idSingleton++, R.drawable.spaghetti, "Yummy Spaghetti", "2021/09/15", u1, 3, comments);
        feedData.add(fd1);

        FeedData fd2 = new FeedData(idSingleton++, R.drawable.gazpacho, "My Summer Gazpacho", "2021/09/15", u2, 10, comments);
        feedData.add(fd2);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
