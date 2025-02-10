package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

public class Regular<T extends Comparable<T>> extends User<T> implements RequestsManager {
    private List<Production> ratedProductions;

    public Regular(Information information, AccountType accountType, String username, int experience, SortedSet<String> favorites) {
        super(information, accountType, username, experience, favorites);
        ratedProductions = new ArrayList<>();
    }

    public List<Production> getRatedProductions() {
        return ratedProductions;
    }

    public void setRatedProductions(List<Production> ratedProductions) {
        this.ratedProductions = ratedProductions;
    }

    public void createRequest(Request r) {
        Request.RequestsHolder.addRequest(r);
    }

    public void removeRequest(Request r) {

    }

    public void addRating(IMDB imdb) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Adaugati o nota unui film");
        System.out.println("2) Adaugati o nota unui serial");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
            System.out.println("Scrieti titlul filmului:");
            String title = scanner.nextLine();
            Movie movie = null;

            for (Production p : imdb.getProductionList())
                if (p.getTitle().equals(title) && (p instanceof Movie))
                    movie = (Movie) p;
            if (movie == null) {
                System.out.println("Nu a fost gasit un film cu titlul " + title + "!");
                return;
            }
            else {
                for (Rating r : movie.getRatingList())
                    if (r.getUsername().equals(getUsername())) {
                        System.out.println("Ati adaugat deja o recenzie pentru acest film!");
                        return;
                    }

                Rating rating = new Rating();
                rating.setUsername(getUsername());
                System.out.println("Scrieti nota (1 - 10):");
                rating.setRating(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Adaugati un comentariu:");
                rating.setComments(scanner.nextLine());

                movie.getRatingList().add(rating);
                movie.setRating(movie.calculateRating());
                if (!(getRatedProductions().contains(movie))) {
                    getRatedProductions().add(movie);
                    increaseExperience();
                }
            }
        } else if (command == 2) {
            System.out.println("Scrieti titlul serialului:");
            String title = scanner.nextLine();
            Series series = null;

            for (Production p : imdb.getProductionList())
                if (p.getTitle().equals(title) && (p instanceof Series))
                    series = (Series) p;
            if (series == null) {
                System.out.println("Nu a fost gasit un serial cu titlul " + title + "!");
                return;
            }
            else {
                for (Rating r : series.getRatingList())
                    if (r.getUsername().equals(getUsername())) {
                        System.out.println("Ati adaugat deja o recenzie pentru acest serial!");
                        return;
                    }

                Rating rating = new Rating();
                rating.setUsername(getUsername());
                System.out.println("Scrieti nota (1 - 10):");
                rating.setRating(scanner.nextInt());
                scanner.nextLine();
                System.out.println("Adaugati un comentariu:");
                rating.setComments(scanner.nextLine());

                series.getRatingList().add(rating);
                series.setRating(series.calculateRating());
                if (!(getRatedProductions().contains(series))) {
                    getRatedProductions().add(series);
                    increaseExperience();
                }
            }
        } else System.out.println("Comanda tastata este invalida!");
    }
}
