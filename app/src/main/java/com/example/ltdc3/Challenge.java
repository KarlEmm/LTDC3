package com.example.ltdc3;

public class Challenge {


    private String challengeName;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(String completionDate) {
        this.completionDate = completionDate;
    }

    private int points;
    private String completionDate;

    public Challenge(String challengeName, int points, String completionDate) {
        this.challengeName = challengeName;
        this.points = points;
        this.completionDate = completionDate;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }

}
