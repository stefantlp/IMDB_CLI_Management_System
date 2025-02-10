package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Movie extends Production {
    private String length;
    private int releaseYear;

    public Movie() {
        super();
        setLength("");
        setReleaseYear(0);
    }

    public Movie(String title, List<String> directorList, List<String> actorList,
                      List<Genre> genreList, List<Rating> ratingList, String description,
                 String length, int releaseYear) {
        super(title, directorList, actorList, genreList, ratingList, description);
        this.length = length;
        setReleaseYear(releaseYear);
    }

    @Override
    public void displayInfo() {
        if (!(getTitle().isEmpty()))
            System.out.println("Titlu: " + getTitle());
        if (!(getDirectorList().isEmpty())) {
            System.out.print("Regizori: ");
            for (String director : getDirectorList())
                System.out.print(director + " ");
            System.out.println();
        }
        if (!(getActorList().isEmpty())) {
            System.out.print("Actori: ");
            for (String actor : getActorList())
                System.out.print(actor + " ");
            System.out.println();
        }
        if (!(getGenreList().isEmpty())) {
            System.out.print("Genuri: ");
            for (Genre genre : getGenreList())
                System.out.print(genre + " ");
            System.out.println();
        }
        if (!(getRatingList().isEmpty())) {
            System.out.print("Note: ");
            for (Rating rating : getRatingList())
                System.out.print(rating + " ");
            System.out.println();
        }
        if (!(getDescription().isEmpty())) {
            System.out.println("Descriere: ");
            System.out.println(getDescription());
        }
        if (!(getLength().isEmpty()))
            System.out.println("Durata: " + length);
        if (getReleaseYear() != 0)
            System.out.println("Anul lansarii: " + releaseYear);
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getType() {
        return "Movie";
    }
}
