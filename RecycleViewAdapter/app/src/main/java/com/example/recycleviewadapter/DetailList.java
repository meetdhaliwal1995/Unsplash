package com.example.recycleviewadapter;

public class DetailList {

    private String Name;
    private String Address;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public DetailList(String ssss, String name, String address) {
        Name = name;
        Address = address;
    }
}

