package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Series extends Production {
    private int releaseYear;
    private int seasonsNumber;
    private Map<String, List<Episode>> seriesMap;

    public Series() {
        super();
        setReleaseYear(0);
        setSeasonsNumber(0);
        seriesMap = new HashMap<>();
    }

    public Series(String title, List<String> directorsList, List<String> actorsList, List<Genre> genresList, List<Rating> ratingsList, String description, int releaseYear, int numberSeasons, Map<String, List<Episode>> seriesMap) {
        super(title, directorsList, actorsList, genresList, ratingsList, description);
        setReleaseYear(releaseYear);
        setSeasonsNumber(numberSeasons);
        setSeriesMap(seriesMap);
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
        if (getReleaseYear() != 0)
            System.out.println("Anul lansarii: " + releaseYear);
        if (getSeasonsNumber() != 0) {
            System.out.println("Numarul de sezoane: " + seasonsNumber);

            int i = 1;
            for (Map.Entry<String, List<Episode>> entry : seriesMap.entrySet()) {
                System.out.println("Sezonul " + i + ": " + entry.getKey());
                System.out.print("Episoade: ");
                for (Episode episode : entry.getValue())
                    System.out.print(episode + " ");
                System.out.println();
            }
        }
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getSeasonsNumber() {
        return seasonsNumber;
    }

    public void setSeasonsNumber(int seasonsNumber) {
        this.seasonsNumber = seasonsNumber;
    }

    public Map<String, List<Episode>> getSeriesMap() {
        return seriesMap;
    }

    public void setSeriesMap(Map<String, List<Episode>> seriesMap) {
        this.seriesMap = seriesMap;
    }

    public String getType() {
        return "Series";
    }
}
