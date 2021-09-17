package com.example.ltdc3;

import android.net.Uri;
import android.widget.ImageView;

import java.util.ArrayList;

public class Database {
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

    public Database() {
        ArrayList<Comment> comments = new ArrayList<>();
        User u1 = new User("karl.bast@gmail.com", "Bastarache", "Karl-Emmanuel", "Séminaire Saint-Joseph", "password", R.drawable.teenager2);
        Comment c1 = new Comment(u1, "This looks very good! Can I have a share tomorrow? :')", "1h");
        comments.add(c1);
        FeedData fd1 = new FeedData(idSingleton++, R.drawable.spaghetti, "Yummy Spaghetti", "2021/09/15", u1, 3, comments);
        users.add(u1);
        feedData.add(fd1);
    }
}
