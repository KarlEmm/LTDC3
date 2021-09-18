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

    public void initDB() {
        ArrayList<Comment> comments = new ArrayList<>();
        User u1 = new User("karl.bast@gmail.com", "Bastarache", "Karl-Emmanuel", "Séminaire Saint-Joseph", "password", R.drawable.teenager2);
        User u2 = new User("lisa.marier@gmail.com", "Marier", "Lisa", "Séminaire Saint-Joseph", "password", R.drawable.teenager1);
        users.add(u1);
        users.add(u2);

        Comment c1 = new Comment(u2, "This looks very good! Can I have a share tomorrow? :')", "1h");
        comments.add(c1);

        FeedData fd1 = new FeedData(idSingleton++, R.drawable.spaghetti, "Yummy Spaghetti", "2021/09/15", u1, 3, comments);
        feedData.add(fd1);

        c1 = new Comment(u1, "What recipe did you follow? This looks amazing.", "34min");
        comments.clear();
        comments.add(c1);
        FeedData fd2 = new FeedData(idSingleton++, R.drawable.gazpacho, "My Summer Gazpacho", "2021/09/15", u2, 10, comments);
        feedData.add(fd2);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
