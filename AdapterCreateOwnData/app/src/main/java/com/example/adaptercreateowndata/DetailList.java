package com.example.adaptercreateowndata;

public class DetailList {

    private String name,Add;
    private int number;

    public DetailList(String name, String add, int number) {
        this.name = name;
        Add = add;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return Add;
    }

    public void setAdd(String add) {
        Add = add;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
