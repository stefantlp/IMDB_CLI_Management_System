package org.example;

import javax.naming.ldap.Control;
import java.awt.image.renderable.ContextualRenderedImageFactory;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Contributor<T extends Comparable<T>> extends Staff<T> implements RequestsManager {
    public Contributor(Information information, AccountType accountType, String username, int experience, SortedSet<String> favorites, SortedSet<String> productionsActorsAdded) {
        super(information, accountType, username, experience, favorites, productionsActorsAdded);
    }

    @Override
    public void createRequest(Request r) {

    }

    @Override
    public void removeRequest(Request r) {

    }
}
