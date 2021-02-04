package com.example.foundcontact;

public class PhnContacts {

    private String name;
    private String number;
    private String id;

    public PhnContacts(String name, String number, String id) {
        this.name = name;
        this.number = number;
        this.id = id;
    }

    public String getId() { return id;
    }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
