package com.example.ltdc3;

import android.net.Uri;

import java.util.ArrayList;

public class FeedData {
    // Recycler view item variables
    private int id;
    private int imagePost;
    private String caption;
    private String timestamp;
    private User user;
    private int likesCount;
    ArrayList<Comment> comments;
    private ArrayList<User> usersLiked;

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }


    public int getImagePost() {
        return imagePost;
    }

    public void setImagePost(int imagePost) {
        this.imagePost = imagePost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void addUserLikes(User user) {
        usersLiked.add(user);
    }

    public void removeUserLikes(User user) {
        usersLiked.remove(user);
    }

    public ArrayList<User> getUserliked() {
        return usersLiked;
    }

    public void incrementLikes() {
        this.likesCount++;
    }

    public FeedData(int id, int imagePost,
                    String caption, String timestamp, User user, int likesCount, ArrayList<Comment> comments) {
        this.id = id;
        this.imagePost = imagePost;
        this.caption = caption;
        this.timestamp = timestamp;
        this.user = user;
        this.likesCount = likesCount;
        this.comments = comments;
        this.usersLiked = new ArrayList<User>();
    }
}
