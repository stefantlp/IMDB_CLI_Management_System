package org.example;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class Actor implements Comparable {
    private String name;
    private List<Map.Entry<String, String>> roles;
    private String biography;

    public Actor() {
        setName("");
        roles = new ArrayList<>();
        setBiography("");
    }

    public Actor(String name, List<Map.Entry<String, String>> roles, String biography) {
        setName(name);
        setRoles(roles);
        setBiography(biography);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

     public List<Map.Entry<String, String>> getRoles() {
        return roles;
     }

     public void setRoles(List<Map.Entry<String, String>> roles) {
        this.roles = roles;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void displayInfo() {
        System.out.println("Nume: " + getName());
        System.out.println("Roluri:");
        for (Map.Entry<String, String> iterator : getRoles())
            System.out.println(iterator.getKey() + " : " + iterator.getValue());
        System.out.println("Biografie: " + getBiography());
    }

    @Override
    public int compareTo(Object o) {
        Actor actor = (Actor) o;

        return getName().compareTo(actor.getName());
    }
}
