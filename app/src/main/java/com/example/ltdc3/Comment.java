package com.example.ltdc3;

public class Comment {
    User user;
    String commentText;
    int nbLikes;
    String timeElapsed;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getTimeElapsed() {
        return timeElapsed;
    }

    public void setTimeElapsed(String timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    public Comment(User user, String commentText, int likes, String timeElapsed) {
        this.user = user;
        this.commentText = commentText;
        this.nbLikes = likes;
        this.timeElapsed = timeElapsed;
    }
}
