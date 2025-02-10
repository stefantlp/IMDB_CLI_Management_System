package org.example;

import java.util.Comparator;

public class Rating {
    private String username;
    private int rating;
    private String comments;

    public Rating() {
        setUsername("");
        setRating(0);
        setComments("");
    }

    public Rating(String username, int rating, String comments) {
        setUsername(username);
        setRating(rating);
        setComments(comments);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String toString() {
        return Integer.toString(rating);
    }
}
