package org.example;

public class Client {
    public String name;
    public int townType;
    public Client(String name, int townType) {
        this.name = name;
        this.townType = townType;
    }
    public String getName() {return name;}
    public double getTownType() {return townType;}
}
