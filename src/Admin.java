package org.example;

import java.util.*;

public class Admin<T extends Comparable<T>> extends Staff<T> {
    public Admin(Information information, AccountType accountType, String username, int experience, SortedSet<String> favorites, SortedSet<String> productionsActorsAdded) {
        super(information, accountType, username, experience, favorites, productionsActorsAdded);
    }

    public void addProductionActor(IMDB imdb) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Adaugati o productie in sistem");
        System.out.println("2) Adaugati un actor in sistem");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
            System.out.println("Selectati o optiune:");
            System.out.println("1) Adaugati un film in sistem");
            System.out.println("2) Adaugati un serial in sistem");

            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 1) {
                Movie movie = new Movie();
                String title;

                System.out.println("Scrieti titlul filmului:");
                title = scanner.nextLine();
                for (Production p : imdb.getProductionList())
                    if ((title.equals(p.getTitle()) && (p instanceof Movie))) {
                        System.out.println("Exista deja un film cu titlul " + title + " in sistem!");
                        return;
                    }
                movie.setTitle(title);

                System.out.println("Scrieti numele regiorului/regizorilor:");
                String names = scanner.nextLine();
                StringTokenizer namesSeparated = new StringTokenizer(names, " ");
                while (namesSeparated.hasMoreTokens()) {
                    String name = namesSeparated.nextToken();
                    movie.getDirectorList().add(name);
                }

                System.out.println("Scrieti numele actorului/actorilor:");
                names = scanner.nextLine();
                namesSeparated = new StringTokenizer(names, " ");
                while (namesSeparated.hasMoreTokens()) {
                    String name = namesSeparated.nextToken();
                    for (Actor a : imdb.getActorList())
                        if (name.equals(a.getName()))
                            movie.getActorList().add(a.getName());
                }

                System.out.println("Scrieti genul/genurile filmului din urmatoarea lista:");
                System.out.println("Action, Adventure, Comendy, Drama, Horror, SF, Fantasy," +
                        " Romance, Mystery, Thriller, Crime, Biography, War");
                String genres = scanner.nextLine();
                StringTokenizer genresSeparated = new StringTokenizer(genres, " ");
                while (genresSeparated.hasMoreTokens()) {
                    String genre = genresSeparated.nextToken();
                    movie.getGenreList().add(Production.Genre.valueOf(genre));
                }

                System.out.println("Scrieti descrierea filmului:");
                movie.setDescription(scanner.nextLine());

                System.out.println("Scrieti durata filmului in minute:");
                movie.setLength(scanner.nextLine());

                System.out.println("Scrieti anul lansarii filmului:");
                String releaseYear = scanner.nextLine();
                if (releaseYear.isEmpty())
                    movie.setReleaseYear(0);
                else {
                    int releaseYearInt = Integer.parseInt(releaseYear);
                    movie.setReleaseYear(releaseYearInt);
                }

                imdb.getProductionList().add(movie);
                getProductionsActorsAdded().add(movie.getTitle());
            } else if (command == 2) {
                Series series = new Series();
                String title;

                title = scanner.nextLine();
                for (Production p : imdb.getProductionList()) {
                    if ((title.equals(p.getTitle())) && (p instanceof Series)) {
                        System.out.println("Exista deja un serial cu titlul " + title + " in sistem!");
                        return;
                    }
                }
                series.setTitle(title);

                System.out.println("Scrieti numele regiorului/regizorilor:");
                String names = scanner.nextLine();
                StringTokenizer namesSeparated = new StringTokenizer(names, " ");
                while (namesSeparated.hasMoreTokens()) {
                    String name = namesSeparated.nextToken();
                    series.getDirectorList().add(name);
                }

                System.out.println("Scrieti numele actorului/actorilor:");
                names = scanner.nextLine();
                namesSeparated = new StringTokenizer(names, " ");
                while (namesSeparated.hasMoreTokens()) {
                    String name = namesSeparated.nextToken();
                    for (Actor a : imdb.getActorList())
                        if (name.equals(a.getName()))
                            series.getActorList().add(a.getName());
                }

                System.out.println("Scrieti genul/genurile serialului din urmatoarea lista:");
                System.out.println("Action, Adventure, Comendy, Drama, Horror, SF, Fantasy," +
                        " Romance, Mystery, Thriller, Crime, Biography, War");
                String genres = scanner.nextLine();
                StringTokenizer genresSeparated = new StringTokenizer(genres, " ");
                while (genresSeparated.hasMoreTokens()) {
                    String genre = genresSeparated.nextToken();
                    series.getGenreList().add(Production.Genre.valueOf(genre));
                }

                System.out.println("Scrieti descrierea serialului:");
                series.setDescription(scanner.nextLine());

                System.out.println("Scrieti anul lansarii serialului:");
                series.setReleaseYear(scanner.nextInt());
                scanner.nextLine();

                System.out.println("Scrieti numarul de sezoane ale serialului:");
                int seasonsNumber = scanner.nextInt();
                scanner.nextLine();
                series.setSeasonsNumber(seasonsNumber);

                for (int i = 1; i <= seasonsNumber; i++) {
                    System.out.println("Scrieti numele sezonului " + i + ":");
                    String seasonName = scanner.nextLine();

                    List<Episode> episodeList = new ArrayList<Episode>();
                    System.out.println("Scrieti numarul de episoade ale sezonului " + i + ":");
                    int episodesNumber = scanner.nextInt();
                    scanner.nextLine();

                    for (int j = 1; j <= episodesNumber; j++) {
                        Episode episode = new Episode();

                        System.out.println("Scrieti numele episodului " + j + ":");
                        episode.setName(scanner.nextLine());

                        System.out.println("Scrieti durata episodului " + j + " in minute:");
                        episode.setLength(scanner.nextLine());

                        episodeList.add(episode);
                    }

                    series.getSeriesMap().put(seasonName, episodeList);
                }

                imdb.getProductionList().add(series);
                getProductionsActorsAdded().add(series.getTitle());
            }
        } else if (command == 2) {
            Actor actor = new Actor();
            String name;

            System.out.println("Scrieti numele actorului:");
            name = scanner.nextLine();
            for (Actor a : imdb.getActorList())
                if (name.equals(a.getName())) {
                    System.out.println("Exista deja un actor cu numele " + name + " in sistem!");
                    return;
                }
            actor.setName(name);

            System.out.println("Scrieti numarul de roluri pe care le-a avut actorul:");
            int rolesNumber = scanner.nextInt();
            scanner.nextLine();

            for (int i = 1; i <= rolesNumber; i++) {
                System.out.println("Scrieti numele productiei in care a avut rolul:");
                String productionName = scanner.nextLine();

                System.out.println("Selectati tipul productiei:");
                System.out.println("1) Film");
                System.out.println("2) Serial");

                String productionTypeName = "";
                int productionType = scanner.nextInt();
                scanner.nextLine();
                if (productionType == 1)
                    productionTypeName = "Movie";
                else if (productionType == 2)
                    productionTypeName = "Series";

                Map.Entry<String, String> role = new AbstractMap.SimpleEntry<String, String>(productionName, productionTypeName);
                actor.getRoles().add(role);
            }

            System.out.println("Scrieti biografia actorului:");
            actor.setBiography(scanner.nextLine());

            imdb.getActorList().add(actor);
            getProductionsActorsAdded().add(actor.getName());
        } else System.out.println("Comanda tastata este invalida!");
    }

    public void addUser() {

    }

    public void deleteUser() {

    }
}
