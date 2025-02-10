package org.example;

import kotlin.enums.EnumEntries;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.*;

public class IMDB {
    private List<User> userList;
    private List<Actor> actorList;
    private List<Request> requestList;
    private List<Production> productionList;

    public IMDB() {
        userList = new ArrayList<User>();
        actorList = new ArrayList<Actor>();
        requestList = new ArrayList<Request>();
        productionList = new ArrayList<Production>();
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Actor> getActorList() {
        return actorList;
    }

    public void setActorList(List<Actor> actorList) {
        this.actorList = actorList;
    }

    public List<Request> getRequestList() {
        return requestList;
    }

    public void setRequestList(List<Request> requestList) {
        this.requestList = requestList;
    }

    public List<Production> getProductionList() {
        return productionList;
    }

    public void setProductionList(List<Production> productionList) {
        this.productionList = productionList;
    }

    public User logIn(String email, String password) {
        for (User user : userList)
            if ((email.equals(user.getInformation().getCredentials().getEmail())) &&
                    (password.equals(user.getInformation().getCredentials().getPassword())))
                return user;

        return null;
    }

    public void visualizeProductions() {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Vizualizati productiile nefiltrate");
        System.out.println("2) Vizualizati productiile filtrate");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            if (productionList.isEmpty())
                System.out.println("Nu exista nicio productie in sistem!");
            else
                for (Production p : productionList) {
                    p.getRatingList().sort(new Comparator<Rating>() {
                        @Override
                        public int compare(Rating r1, Rating r2) {
                            String username1 = r1.getUsername();
                            String username2 = r2.getUsername();
                            User u1 = null, u2 = null;

                            for (User u : userList) {
                                if (username1.equals(u.getUsername()))
                                    u1 = u;
                                if (username2.equals(u.getUsername()))
                                    u2 = u;
                            }

                            return u1.getExperience() - u2.getExperience();
                        }
                    });
                    p.displayInfo();
                    System.out.println();
                }
        else if (command == 2) {
            System.out.println("Selectati o optiune:");
            System.out.println("1) Filtrati dupa gen");
            System.out.println("2) Filtrati dupa numarul de recenzii");
            System.out.println("3) Filtrati dupa gen si dupa numarul de recenzii");

            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 1) {
                System.out.println("Scrieti genurile dupa care doriti sa filtrati din urmatoarea lista:");
                System.out.println("ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, SF, FANTASY," +
                        " ROMANCE, MYSTERY, THRILLER, CRIME, BIOGRAPHY, WAR, COOKING");

                String genres = scanner.nextLine();
                StringTokenizer genresSeparated = new StringTokenizer(genres, " ");
                List<Production.Genre> genreList = new ArrayList<Production.Genre>();

                while (genresSeparated.hasMoreTokens()) {
                    String genre = genresSeparated.nextToken();
                    genreList.add(Production.Genre.valueOf(genre));
                }

                boolean ok = false;
                for (Production p : productionList)
                    if (p.getGenreList().containsAll(genreList)) {
                        p.getRatingList().sort(new Comparator<Rating>() {
                            @Override
                            public int compare(Rating r1, Rating r2) {
                                String username1 = r1.getUsername();
                                String username2 = r2.getUsername();
                                User u1 = null, u2 = null;

                                for (User u : userList) {
                                    if (username1.equals(u.getUsername()))
                                        u1 = u;
                                    if (username2.equals(u.getUsername()))
                                        u2 = u;
                                }

                                return u1.getExperience() - u2.getExperience();
                            }
                        });
                        p.displayInfo();
                        System.out.println();
                        ok = true;
                    }
                if (!ok)
                    System.out.println("Nu a fost gasita nicio productie dupa filtrarea dorita!");
            } else if (command == 2) {
                System.out.println("Scrieti numarul minim de recenzii dupa care doriti sa filtrati:");
                int minReviews = scanner.nextInt();
                scanner.nextLine();

                boolean ok = false;
                for (Production p : productionList)
                    if (p.getRatingList().size() >= minReviews) {
                        p.getRatingList().sort(new Comparator<Rating>() {
                            @Override
                            public int compare(Rating r1, Rating r2) {
                                String username1 = r1.getUsername();
                                String username2 = r2.getUsername();
                                User u1 = null, u2 = null;

                                for (User u : userList) {
                                    if (username1.equals(u.getUsername()))
                                        u1 = u;
                                    if (username2.equals(u.getUsername()))
                                        u2 = u;
                                }

                                return u1.getExperience() - u2.getExperience();
                            }
                        });
                        p.displayInfo();
                        System.out.println();
                        ok = true;
                    }
                if (!ok)
                    System.out.println("Nu a fost gasita nicio productie dupa filtrarea dorita!");
            } else if (command == 3) {
                System.out.println("Scrieti genurile dupa care doriti sa filtrati din urmatoarea lista:");
                System.out.println("ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, SF, FANTASY," +
                        " ROMANCE, MYSTERY, THRILLER, CRIME, BIOGRAPHY, WAR, COOKING");

                String genres = scanner.nextLine();
                StringTokenizer genresSeparated = new StringTokenizer(genres, " ");
                List<Production.Genre> genreList = new ArrayList<Production.Genre>();

                while (genresSeparated.hasMoreTokens()) {
                    String genre = genresSeparated.nextToken();
                    genreList.add(Production.Genre.valueOf(genre));
                }

                System.out.println("Scrieti numarul minim de recenzii dupa care doriti sa filtrati:");
                int minReviews = scanner.nextInt();
                scanner.nextLine();

                boolean ok = false;
                for (Production p : productionList)
                    if ((p.getGenreList().containsAll(genreList)) && (p.getRatingList().size() >= minReviews)) {
                        p.getRatingList().sort(new Comparator<Rating>() {
                            @Override
                            public int compare(Rating r1, Rating r2) {
                                String username1 = r1.getUsername();
                                String username2 = r2.getUsername();
                                User u1 = null, u2 = null;

                                for (User u : userList) {
                                    if (username1.equals(u.getUsername()))
                                        u1 = u;
                                    if (username2.equals(u.getUsername()))
                                        u2 = u;
                                }

                                return u1.getExperience() - u2.getExperience();
                            }
                        });
                        p.displayInfo();
                        System.out.println();
                        ok = true;
                    }
                if (!ok)
                    System.out.println("Nu a fost gasita nicio productie dupa filtrarea dorita!");
            } else System.out.println("Comanda tastata este invalida!");
        } else System.out.println("Comanda tastata este invalida!");
    }

    public void visualizeActors() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selectati o optiune:");
        System.out.println("1) Vizualizati actorii in ordine aleatorie");
        System.out.println("2) Vizualizati actorii in ordine alfabetica dupa nume");

        int command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            if (actorList.isEmpty())
                System.out.println("Nu exista niciun actor in sistem!");
            else
                for (Actor a : actorList) {
                    a.displayInfo();
                    System.out.println();
                }
        else if (command == 2) {
            if (actorList.isEmpty())
                System.out.println("Nu exista niciun actor in sistem!");
            else {
                List<Actor> sortedActorList = new ArrayList<Actor>(actorList);
                Collections.sort(sortedActorList);

                for (Actor a : sortedActorList) {
                    a.displayInfo();
                    System.out.println();
                }
            }
        } else System.out.println("Comanda tastata este invalida!");
    }

    public void visualizeNotifications(User user) {
        System.out.println("Notificarile dvs.:");
        user.displayNotifications();
    }

    public void searchProductionActor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti numele filmului/serialului/actorului cautat:");
        String name = scanner.nextLine();

        boolean ok1 = false, ok2 = false;
        for (Production p : productionList)
            if (name.equals(p.getTitle())) {
                p.getRatingList().sort(new Comparator<Rating>() {
                    @Override
                    public int compare(Rating r1, Rating r2) {
                        String username1 = r1.getUsername();
                        String username2 = r2.getUsername();
                        User u1 = null, u2 = null;

                        for (User u : userList) {
                            if (username1.equals(u.getUsername()))
                                u1 = u;
                            if (username2.equals(u.getUsername()))
                                u2 = u;
                        }

                        return u1.getExperience() - u2.getExperience();
                    }
                });
                p.displayInfo();
                ok1 = true;
            }
        for (Actor a : actorList)
            if (name.equals(a.getName())) {
                a.displayInfo();
                ok2 = true;
            }
        if ((!ok1) && (!ok2))
            System.out.println("Nu a fost gasit niciun film/serial/actor cu numele " + name + "!");
    }

    public void addOrDeleteFavorite(User user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Adaugati film/serial/actor in lista de favorite");
        System.out.println("2) Stergeti film/serial/actor din lista de favorite");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
            System.out.println("Selectati o optiune:");
            System.out.println("1) Adaugati un film in lista de favorite");
            System.out.println("2) Adaugati un serial in lista de favorite");
            System.out.println("3) Adaugati un actor in lista de favorite");

            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 1) {
                String title;

                System.out.println("Introduceti titlul filmului pe care doriti sa-l adaugati in lista de favorite:");
                title = scanner.nextLine();

                boolean ok = false;
                for (Production p : productionList)
                    if (title.equals(p.getTitle()) && (p instanceof Movie)) {
                        user.addFavorite(p.getTitle());
                        System.out.println("Filmul " + p.getTitle() + " a fost adaugat in lista de favorite!");
                        ok = true;
                    }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun film cu titlul " + title + "!");
            } else if (command == 2) {
                String title;

                System.out.println("Introduceti titlul serialului pe care doriti sa-l adaugati in lista de favorite:");
                title = scanner.nextLine();

                boolean ok = false;
                for (Production p : productionList)
                    if (title.equals(p.getTitle()) && (p instanceof Series)) {
                        user.addFavorite(p.getTitle());
                        System.out.println("Serialul " + p.getTitle() + " a fost adaugat in lista de favorite!");
                        ok = true;
                    }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun serial cu titlul " + title + "!");
            } else if (command == 3) {
                String name;

                System.out.println("Introduceti numele actorului pe care doriti sa-l adaugati in lista de favorite:");
                name = scanner.nextLine();

                boolean ok = false;
                for (Actor a : actorList)
                    if (name.equals(a.getName())) {
                        user.addFavorite(a.getName());
                        System.out.println("Actorul " + a.getName() + " a fost adaugat in lista de favorite!");
                        ok = true;
                    }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun actor cu numele " + name + "!");
            } else System.out.println("Comanda tastata este invalida!");
        } else if (command == 2) {
            System.out.println("Selectati o optiune:");
            System.out.println("1) Stergeti un film din lista de favorite");
            System.out.println("2) Stergeti un serial din lista de favorite");
            System.out.println("3) Stergeti un actor din lista de favorite");

            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 1) {
                String title;

                System.out.println("Introduceti titlul filmului pe care doriti sa-l stergeti din lista de favorite:");
                title = scanner.nextLine();

                boolean ok = false;
                for (Production p : productionList)
                    if (title.equals(p.getTitle()) && (p instanceof Movie))
                        if (user.removeFavorite(p.getTitle())) {
                            System.out.println("Filmul " + p.getTitle() + " a fost sters din lista de favorite!");
                            ok = true;
                        }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun film cu titlul " + title + " in lista de favorite!");
            } else if (command == 2) {
                String title;

                System.out.println("Introduceti titlul serialului pe care doriti sa-l stergeti din lista de favorite:");
                title = scanner.nextLine();

                boolean ok = false;
                for (Production p : productionList)
                    if (title.equals(p.getTitle()) && (p instanceof Series))
                        if (user.removeFavorite(p.getTitle())) {
                            System.out.println("Serialul " + p.getTitle() + " a fost sters din lista de favorite!");
                            ok = true;
                        }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun serial cu titlul " + title + " in lista de favorite!");
            } else if (command == 3) {
                String name;

                System.out.println("Introduceti numele actorului pe care doriti sa-l stergeti din lista de favorite:");
                name = scanner.nextLine();

                boolean ok = false;
                for (Actor a : actorList)
                    if (name.equals(a.getName())) {
                        if (user.removeFavorite(a.getName())) {
                            System.out.println("Actorul " + a.getName() + " a fost sters din lista de favorite!");
                            ok = true;
                        }
                    }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun actor cu numele " + name + " in lista de favorite!");
            } else System.out.println("Comanda tastata este invalida!");
        } else System.out.println("Comanda tastata este invalida!");
    }

    public void createOrRemoveRequest(Regular user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Creati o cerere");
        System.out.println("2) Retrageti o cerere");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
            Request request = new Request();

            System.out.println("Alegeti tipul cererii:");
            System.out.println("1) DELETE_ACCOUNT");
            System.out.println("2) ACTOR_ISSUE");
            System.out.println("3) MOVIE_ISSUE");
            System.out.println("4) OTHERS");
            request.setRequestType(Request.RequestType.valueOf(scanner.nextLine()));

            System.out.println("Descrieti problema:");
            request.setProblemDescription(scanner.nextLine());
            request.setCreatedUsername(user.getUsername());
            request.setCreationDate(LocalDateTime.now());

            if ((request.getRequestType() == Request.RequestType.DELETE_ACCOUNT) ||
                    (request.getRequestType() == Request.RequestType.OTHERS))
                request.setAssignedUsername("ADMIN");
            else request.setAssignedUsername("Nu stiu inca");

            request.setTitleOrName("");

            user.createRequest(request);
        } else if (command == 2) {

        } else System.out.println("Comanda tastata este invalida!");
    }

    public void createOrRemoveRequest(Contributor user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Creati o cerere");
        System.out.println("2) Retrageti o cerere");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
            Request request = new Request();

            System.out.println("Alegeti tipul cererii:");
            System.out.println("1) DELETE_ACCOUNT");
            System.out.println("2) ACTOR_ISSUE");
            System.out.println("3) MOVIE_ISSUE");
            System.out.println("4) OTHERS");
            request.setRequestType(Request.RequestType.valueOf(scanner.nextLine()));

            System.out.println("Descrieti problema:");
            request.setProblemDescription(scanner.nextLine());
            request.setCreatedUsername(user.getUsername());
            request.setCreationDate(LocalDateTime.now());

            if ((request.getRequestType() == Request.RequestType.DELETE_ACCOUNT) ||
                    (request.getRequestType() == Request.RequestType.OTHERS))
                request.setAssignedUsername("ADMIN");
            else request.setAssignedUsername("Nu stiu inca");

            request.setTitleOrName(null);

            user.createRequest(request);

            scanner.close();
        } else if (command == 2) {

        } else System.out.println("Comanda tastata este invalida!");
    }

    public void addOrDeleteProductionActor(Staff user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Adaugati o productie/un actor in sistem");
        System.out.println("2) Stergeti o productie/un actor din sistem");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
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
                    for (Production p : getProductionList())
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
                        for (Actor a : getActorList())
                            if (name.equals(a.getName()))
                                movie.getActorList().add(a.getName());
                    }

                    System.out.println("Scrieti genul/genurile filmului din urmatoarea lista:");
                    System.out.println("ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, SF, FANTASY," +
                            " ROMANCE, MYSTERY, THRILLER, CRIME, BIOGRAPHY, WAR, COOKING");
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

                    getProductionList().add(movie);
                    user.getProductionsActorsAdded().add(movie);
                    user.increaseExperience();
                } else if (command == 2) {
                    Series series = new Series();
                    String title;

                    title = scanner.nextLine();
                    for (Production p : getProductionList()) {
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
                        for (Actor a : getActorList())
                            if (name.equals(a.getName()))
                                series.getActorList().add(a.getName());
                    }

                    System.out.println("Scrieti genul/genurile serialului din urmatoarea lista:");
                    System.out.println("ACTION, ADVENTURE, COMEDY, DRAMA, HORROR, SF, FANTASY," +
                            " ROMANCE, MYSTERY, THRILLER, CRIME, BIOGRAPHY, WAR, COOKING");
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

                    getProductionList().add(series);
                    user.getProductionsActorsAdded().add(series);
                    user.increaseExperience();
                } else System.out.println("Comanda tastata este invalida!");
            } else if (command == 2) {
                Actor actor = new Actor();
                String name;

                System.out.println("Scrieti numele actorului:");
                name = scanner.nextLine();
                for (Actor a : getActorList())
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

                getActorList().add(actor);
                user.getProductionsActorsAdded().add(actor);
                user.increaseExperience();
            } else System.out.println("Comanda tastata este invalida!");
        } else if (command == 2) {
            System.out.println("Selectati o optiune:");
            System.out.println("1) Stergeti o productie din sistem");
            System.out.println("2) Stergeti un actor din sistem");

            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 1) {
                System.out.println("Selectati o optiune:");
                System.out.println("1) Stergeti un film din sistem");
                System.out.println("2) Stergeti un serial din sistem");

                command = scanner.nextInt();
                scanner.nextLine();
                if (command == 1) {
                    List<String> names = new ArrayList<>();
                    String name;
                    boolean ok = false;
                    System.out.println("Aveti aici o lista cu filmele pe care le puteti sterge:");
                    for (Object obj : user.getProductionsActorsAdded()) {
                        name = (String) obj;
                        for (Production p : getProductionList())
                            if ((name.equals(p.getTitle())) && (p instanceof Movie)) {
                                System.out.println(name);
                                names.add(name);
                                ok = true;
                            }
                    }
                    if (!ok) {
                        System.out.println("Nu a fost gasit niciun film adaugat de dvs. in sistem!");
                        return;
                    }

                    System.out.println("Scrieti titlul filmului pe care doriti sa-l stergeti din sistem:");
                    String title = scanner.nextLine();

                    ok = false;
                    for (Production p : getProductionList())
                        if (title.equals(p.getTitle())) {
                            user.removeProductionSystem(this, p.getTitle());
                            user.getProductionsActorsAdded().remove(p.getTitle());
                            System.out.println("Filmul " + title + " a fost sters din sistem!");

                            for (User u : getUserList()) {
                                u.getFavorites().remove(p.getTitle());
                                if (u instanceof Regular) {
                                    Regular regular = (Regular) u;
                                    regular.getRatedProductions().remove(p);
                                }
                            }

                            ok = true;
                            break;
                        }
                    if (!ok)
                        System.out.println("Nu a fost gasit niciun film cu titlul " + title + " in sistem!");
                } else if (command == 2) {
                    List<String> names = new ArrayList<>();
                    String name;
                    boolean ok = false;
                    System.out.println("Aveti aici o lista cu serialele pe care le puteti sterge:");
                    for (Object obj : user.getProductionsActorsAdded()) {
                        name = (String) obj;
                        for (Production p : getProductionList())
                            if ((name.equals(p.getTitle())) && (p instanceof Series)) {
                                System.out.println(name);
                                names.add(name);
                                ok = true;
                            }
                    }
                    if (!ok) {
                        System.out.println("Nu a fost gasit niciun serial adaugat de dvs. in sistem!");
                        return;
                    }

                    System.out.println("Scrieti titlul serialului pe care doriti sa-l stergeti din sistem:");
                    String title = scanner.nextLine();

                    ok = false;
                    for (Production p : getProductionList())
                        if (title.equals(p.getTitle())) {
                            user.removeProductionSystem(this, p.getTitle());
                            user.getProductionsActorsAdded().remove(p.getTitle());
                            System.out.println("Serialul " + title + " a fost sters din sistem!");

                            for (User u : getUserList()) {
                                u.getFavorites().remove(p.getTitle());
                                if (u instanceof Regular) {
                                    Regular regular = (Regular) u;
                                    regular.getRatedProductions().remove(p);
                                }
                            }

                            ok = true;
                        }
                    if (!ok)
                        System.out.println("Nu a fost gasit niciun serial cu titlul " + title + " in sistem!");
                } else System.out.println("Comanda tastata este invalida!");
            } else if (command == 2) {
                List<String> names = new ArrayList<>();
                String name;
                boolean ok = false;
                System.out.println("Aveti aici o lista cu actorii pe care ii puteti sterge:");
                for (Object obj : user.getProductionsActorsAdded()) {
                    name = (String) obj;
                    for (Actor a : getActorList())
                        if (name.equals(a.getName())) {
                            System.out.println(name);
                            names.add(name);
                            ok = true;
                        }
                }
                if (!ok) {
                    System.out.println("Nu a fost gasit niciun actor adaugat de dvs. in sistem!");
                    return;
                }

                System.out.println("Scrieti numele actorului pe care doriti sa-l stergeti din sistem:");
                name = scanner.nextLine();

                ok = false;
                if (names.contains(name)) {
                    for (Actor a : getActorList())
                        if (name.equals(a.getName())) {
                            user.removeActorSystem(this, a.getName());
                            user.getProductionsActorsAdded().remove(a.getName());
                            System.out.println("Actorul " + name + " a fost sters din sistem!");

                            for (User u : getUserList())
                                u.getFavorites().remove(a.getName());

                            ok = true;
                        }
                }
                if (!ok)
                    System.out.println("Nu a fost gasit niciun actor cu numele " + name + " adaugat de dvs. in sistem!");
            } else System.out.println("Comanda tastata este invalida!");
        } else System.out.println("Comanda tastata este invalida!");
    }


    public void visualizeAndResolveRequests() {

    }

    public void updateProductionActor() {

    }

    public void addOrDeleteRating(Regular user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Adaugati o recenzie pentru o productie");
        System.out.println("2) Stergeti o recenzie pentru o productie");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            user.addRating(this);
        else if (command == 2) {
            System.out.println("Selectati o optiune:");
            System.out.println("1) Stergeti recenzia unui film");
            System.out.println("2) Stergeti recenzia unui serial");

            command = scanner.nextInt();
            scanner.nextLine();
            if (command == 1) {
                System.out.println("Scrieti titlul filmului pentru care doriti sa stergeti recenzia:");
                String title = scanner.nextLine();

                boolean ok1 = false, ok2 = false;
                for (Production p : productionList)
                    if (title.equals(p.getTitle()) && (p instanceof Movie)) {
                        for (Rating r : p.getRatingList())
                            if (r.getUsername().equals(user.getUsername())) {
                                p.getRatingList().remove(r);
                                System.out.println("Recenzia dvs. pentru filmul " + title + " a fost stearsa!");
                                ok2 = true;
                                p.setRating(p.calculateRating());
                            }
                        ok1 = true;
                    }
                if (!ok1)
                    System.out.println("Nu a fost gasit niciun film cu titlul " + title + " in sistem!");
                if (!ok2)
                    System.out.println("Nu ati adaugat nicio recenzie pentru filmul " + title + "!");
            } else if (command == 2) {
                System.out.println("Scrieti titlul serialului pentru care doriti sa stergeti recenzia:");
                String title = scanner.nextLine();

                boolean ok1 = false, ok2 = false;
                for (Production p : productionList)
                    if (title.equals(p.getTitle()) && (p instanceof Series)) {
                        for (Rating r : p.getRatingList())
                            if (r.getUsername().equals(user.getUsername())) {
                                p.getRatingList().remove(r);
                                System.out.println("Recenzia dvs. pentru serialul " + title + " a fost stearsa!");
                                ok2 = true;
                                p.setRating(p.calculateRating());
                            }
                        ok1 = true;
                    }
                if (!ok1)
                    System.out.println("Nu a fost gasit niciun serial cu titlul " + title + " in sistem!");
                if (!ok2)
                    System.out.println("Nu ati adaugat nicio recenzie pentru serialul " + title + "!");
            } else System.out.println("Comanda tastata este invalida!");
        } else System.out.println("Comanda tastata este invalida!");
    }

    public void addOrDeleteUser() {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Adaugati un utilizator in sistem");
        System.out.println("2) Stergeti un utilizator din sistem");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1) {
            
        } else if (command == 2) {
            System.out.println("Scrieti username-ul utilizatorului pe care doriti sa-l stergeti din sistem:");
            String username = scanner.nextLine();

            boolean ok = false;
            for (User u : userList)
                if (username.equals(u.getUsername())) {
                    userList.remove(u);
                    System.out.println("Utilizatorul " + username + " a fost sters din sistem!");
                    ok = true;
                }
            if (!ok)
                System.out.println("Nu a fost gasit niciun utilizator cu username-ul " + username + " in sistem!");
        } else System.out.println("Comanda tastata este invalida!");
    }

    public void logOut(User user) {
        user.logOut(this);
    }

    public void regularFlow(Regular user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o actiune:");
        System.out.println("1) Vizualizarea detaliilor tuturor productiilor din sistem");
        System.out.println("2) Vizualizarea detaliilor tuturor actorilor din sistem");
        System.out.println("3) Vizualizarea notificărilor primite");
        System.out.println("4) Căutarea unui anumit film/serial/actor");
        System.out.println("5) Adăugarea/Stergerea unei productii/actor din lista de favorite");
        System.out.println("6) Crearea/Retragerea unei cereri");
        System.out.println("7) Adăugarea/Stergerea unei recenzii pentru o productie ");
        System.out.println("8) Delogare");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            visualizeProductions();
        else if (command == 2)
            visualizeActors();
        else if (command == 3)
            visualizeNotifications(user);
        else if (command == 4)
            searchProductionActor();
        else if (command == 5)
            addOrDeleteFavorite(user);
        else if (command == 6)
            createOrRemoveRequest(user);
        else if (command == 7)
            addOrDeleteRating(user);
        else if (command == 8)
            logOut(user);
        else System.out.println("Comanda tastata este invalida!");

        regularFlow(user);
    }

    public void contributorFlow(Contributor user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o actiune:");
        System.out.println("1) Vizualizarea detaliilor tuturor productiilor din sistem");
        System.out.println("2) Vizualizarea detaliilor tuturor actorilor din sistem");
        System.out.println("3) Vizualizarea notificărilor primite");
        System.out.println("4) Căutarea unui anumit film/serial/actor");
        System.out.println("5) Adăugarea/Stergerea unei productii/actor din lista de favorite");
        System.out.println("6) Crearea/Retragerea unei cereri");
        System.out.println("7) Adăugarea/Stergerea unei productii/actor din sistem");
        System.out.println("8) Vizualizarea si rezolvarea cererilor primite");
        System.out.println("9) Actualizarea informatiilor despre productii/actori");
        System.out.println("10) Delogare");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            visualizeProductions();
        else if (command == 2)
            visualizeActors();
        else if (command == 3)
            visualizeNotifications(user);
        else if (command == 4)
            searchProductionActor();
        else if (command == 5)
            addOrDeleteFavorite(user);
        else if (command == 6)
            createOrRemoveRequest(user);
        else if (command == 7)
            addOrDeleteProductionActor(user);
        else if (command == 8)
            visualizeAndResolveRequests();
        else if (command == 9)
            updateProductionActor();
        else if (command == 10)
            logOut(user);
        else System.out.println("Comanda tastata este invalida!");

        contributorFlow(user);
    }

    public void adminFlow(Admin user) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o actiune:");
        System.out.println("1) Vizualizarea detaliilor tuturor productiilor din sistem");
        System.out.println("2) Vizualizarea detaliilor tuturor actorilor din sistem");
        System.out.println("3) Vizualizarea notificărilor primite");
        System.out.println("4) Căutarea unui anumit film/serial/actor");
        System.out.println("5) Adăugarea/Stergerea unei productii/actor din lista de favorite");
        System.out.println("6) Adăugarea/Stergerea unei productii/actor din sistem");
        System.out.println("7) Vizualizarea si rezolvarea cererilor primite");
        System.out.println("8) Actualizarea informatiilor despre productii/actori");
        System.out.println("9) Adăugarea/Stergerea unui utilizator din sistem ");
        System.out.println("10) Delogare");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            visualizeProductions();
        else if (command == 2)
            visualizeActors();
        else if (command == 3)
            visualizeNotifications(user);
        else if (command == 4)
            searchProductionActor();
        else if (command == 5)
            addOrDeleteFavorite(user);
        else if (command == 6)
            addOrDeleteProductionActor(user);
        else if (command == 7)
            visualizeAndResolveRequests();
        else if (command == 8)
            updateProductionActor();
        else if (command == 9)
            addOrDeleteUser();
        else if (command == 10)
            logOut(user);
        else System.out.println("Comanda tastata este invalida!");

        adminFlow(user);
    }

    public void run() {
        userList = Input.readUsers();
        productionList = Input.readProductions();
        actorList = Input.readActors();

        Scanner scanner = new Scanner(System.in);
        User user;
        String email, password;

        System.out.println("Bine ati venit la IMDB! Introduceti datele de logare!");

        while (true) {
            System.out.println("Intoduceti email-ul dvs.:");
            email = scanner.nextLine();
            System.out.println("Introduceti parola dvs.:");
            password = scanner.nextLine();

            user = logIn(email, password);
            if (user != null)
                break;
            System.out.println("Datele de logare sunt incorecte. Incercati din nou!");
        }

        System.out.println("Bine ati venit " + user.getUsername() + "!");

        if (user.getAccountType() == User.AccountType.REGULAR)
            regularFlow((Regular) user);
        if (user.getAccountType() == User.AccountType.CONTRIBUTOR)
            contributorFlow((Contributor) user);
        if (user.getAccountType() == User.AccountType.ADMIN)
            adminFlow((Admin) user);
    }
}