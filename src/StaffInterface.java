package org.example;

public interface StaffInterface {
    public void addProductionSystem(IMDB imdb, Production p);
    public void addActorSystem(IMDB imdb, Actor a);
    public void removeProductionSystem(IMDB imdb ,String name);
    public void removeActorSystem(IMDB imdb, String name);
    public void updateProduction(IMDB imdb, Production p);
    public void updateActor(IMDB imdb, Actor a);
}
