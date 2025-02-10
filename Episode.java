package org.example;

public class Episode {
    private String name;
    private String length;

    public Episode() {
        setName("");
        setLength("");
    }

    public Episode(String name, String length) {
        setName(name);
        setLength(length);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String toString() {
        return getName();
    }
}
