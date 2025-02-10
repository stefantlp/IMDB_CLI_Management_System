package org.example;

import java.util.*;


public interface UserFactory {
    User createUser(User.Information information, User.AccountType accountType, String username, int experience, List<String> favorites, SortedSet<String> productionsActorsAdded);
}

class UserFactoryClass<T extends Comparable<T>> implements UserFactory {
    public User createUser(User.Information information, User.AccountType accountType, String username, int experience, List<String> favorites, SortedSet<String> productionsActorsAdded) {
        List<Production> productionList = Input.readProductions();

        SortedSet<String> favoritesSet = new TreeSet<>(favorites);
        SortedSet<String> productionsActorsAddedSet = new TreeSet<>(productionsActorsAdded);

        if (accountType == User.AccountType.ADMIN)
            return new Admin(information, accountType, username, experience, favoritesSet, productionsActorsAddedSet);
        else if (accountType == User.AccountType.CONTRIBUTOR)
            return new Contributor(information, accountType, username, experience, favoritesSet, productionsActorsAddedSet);
        else if (accountType == User.AccountType.REGULAR)
            return new Regular(information, accountType, username, experience, favoritesSet);
        else
            return null;
    }
}

