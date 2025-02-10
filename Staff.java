package org.example;

import java.lang.Comparable;
import java.util.*;

public abstract class Staff<T extends Comparable<T>> extends User<T> implements StaffInterface {
    private List<Request> myRequestList;
    private SortedSet<String> productionsActorsAdded;

    public Staff() {
        super();
        myRequestList = new ArrayList<>();
        productionsActorsAdded = new TreeSet<>();
    }

    public Staff(Information information, AccountType accountType, String username, int experience, SortedSet<String> favorites, SortedSet<String> productionsActorsAdded) {
        super(information, accountType, username, experience, favorites);
        myRequestList = new ArrayList<>();
        setProductionsActorsAdded(productionsActorsAdded);
    }

    public List<Request> getMyRequestList() {
        return myRequestList;
    }

    public void setMyRequestList(List<Request> myRequestList) {
        this.myRequestList = myRequestList;
    }

    public SortedSet<String> getProductionsActorsAdded() {
        return productionsActorsAdded;
    }

    public void setProductionsActorsAdded(SortedSet<String> productionsActorsAdded) {
        this.productionsActorsAdded = productionsActorsAdded;
    }

    public void addProductionSystem(IMDB imdb, Production p) {
        imdb.getProductionList().add(p);
    }
    public void addActorSystem(IMDB imdb, Actor a) {
        imdb.getActorList().add(a);
    }
    public void removeProductionSystem(IMDB imdb, String name) {
        for (Production p : imdb.getProductionList()) {
            if (p.getTitle().equals(name)) {
                imdb.getProductionList().remove(p);
                break;
            }
        }
    }
    public void removeActorSystem(IMDB imdb, String name) {
        for (Actor a : imdb.getActorList()) {
            if (a.getName().equals(name)) {
                imdb.getActorList().remove(a);
                break;
            }
        }
    }
    public void updateProduction(IMDB imdb, Production p) {

    }
    public void updateActor(IMDB imdb, Actor a) {

    }

    public void solveRequest(IMDB imdb, Request r) {

    }

}
