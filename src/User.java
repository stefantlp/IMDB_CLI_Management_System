package org.example;

import javax.management.Notification;
import java.time.LocalDateTime;
import java.util.*;

public abstract class User<T extends Comparable<T>> {
    public static class Information {
        private Credentials credentials;
        private String name;
        private String country;
        private int age;
        private String gender;
        private LocalDateTime birthDate;

        public Information() {
            setCredentials(new Credentials());
            setName("");
            setCountry("");
            setAge(0);
            setGender("");
            setBirthDate(null);
        }

        public Information(Credentials credentials, String name, String country, int age,
                           String gender, LocalDateTime birthDate) {
            setCredentials(credentials);
            setName(name);
            setCountry(country);
            setAge(age);
            setGender(gender);
            setBirthDate(birthDate);
        }

        public Credentials getCredentials() {
            return credentials;
        }

        public void setCredentials(Credentials credentials) {
            this.credentials = credentials;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public LocalDateTime getBirthDate() {
            return birthDate;
        }

        public void setBirthDate(LocalDateTime birthDate) {
            this.birthDate = birthDate;
        }
    }

    public enum AccountType {
        REGULAR, CONTRIBUTOR, ADMIN
    }
    private Information information;
    private AccountType accountType;
    private String username;
    private int experience;
    private List<String> notifications;
    private SortedSet<String> favorites;

    public User() {
        information = new Information();
        accountType = AccountType.REGULAR;
        username = "";
        experience = 0;
        notifications = new ArrayList<>();
        favorites = new TreeSet<>();
    }

    public User(Information information, AccountType accountType, String username, int experience, SortedSet<String> favorites) {
        setInformation(information);
        setAccountType(accountType);
        setUsername(username);
        setExperience(experience);
        notifications = new ArrayList<>();
        setFavorites(favorites);
    }

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<String> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<String> notifications) {
        this.notifications = notifications;
    }

    public SortedSet<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(SortedSet<String> favorites) {
        this.favorites = favorites;
    }

    public void displayNotifications() {
        if (notifications.isEmpty()) {
            System.out.println("Nu aveti nicio notificare!");
            return;
        }
        for (String n : notifications)
            System.out.println(n);
    }

    public void addFavorite(String favorite) {
        favorites.add(favorite);
    }

    public boolean removeFavorite(String favorite) {
        return favorites.remove(favorite);
    }

    public void increaseExperience() {

    }

    public void logOut(IMDB imdb) {
        Scanner scanner = new Scanner(System.in);
        int command;

        System.out.println("Selectati o optiune:");
        System.out.println("1) Autentificati-va din nou");
        System.out.println("2) Inchideti aplicatia");

        command = scanner.nextInt();
        scanner.nextLine();
        if (command == 1)
            imdb.run();
        else if (command == 2)
            System.exit(0);
        else {
            System.out.println("Comanda tastata este invalida!");
            logOut(imdb);
        }
    }
}
