package org.example;

import javax.sound.sampled.Port;
import java.util.*;

public abstract class Production implements Comparable {
    private String title;
    private List<String> directorList;
    private List<String> actorList;
    private List<Genre> genreList;
    private List<Rating> ratingList;
    private String description;
    private double rating;

    public enum Genre {
        ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, SF, FANTASY,
        ROMANCE, MYSTERY, THRILLER, CRIME, BIOGRAPHY, WAR, COOKING
    }

    public Production() {
        setTitle("");
        directorList = new ArrayList<>();
        actorList = new ArrayList<>();
        genreList = new ArrayList<>();
        ratingList = new ArrayList<>();
        setDescription("");
        setRating(calculateRating());
    }

    public Production(String title, List<String> directorList, List<String> actorList,
                      List<Genre> genreList, List<Rating> ratingList, String description) {
        setTitle(title);
        setDirectorList(directorList);
        setActorList(actorList);
        setGenreList(genreList);
        setRatingList(ratingList);
        setDescription(description);
        setRating(calculateRating());
    }

    public double calculateRating() {
        if (ratingList.isEmpty())
            return 0.0;

        int sum = 0;

        for (Rating r : ratingList)
            sum += r.getRating();

        return (double) (sum / ratingList.size());
    }

    public abstract void displayInfo();

    public int compareTo(Object o) {
        Production production = (Production) o;

        return title.compareTo(production.title);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDirectorList() {
        return directorList;
    }

    public void setDirectorList(List<String> directorList) {
        this.directorList = directorList;
    }

    public List<String> getActorList() {
        return actorList;
    }

    public void setActorList(List<String> actorList) {
        this.actorList = actorList;
    }

    public List<Genre> getGenreList() {
        return genreList;
    }

    public void setGenreList(List<Genre> genreList) {
        this.genreList = genreList;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public abstract String getType();
}
