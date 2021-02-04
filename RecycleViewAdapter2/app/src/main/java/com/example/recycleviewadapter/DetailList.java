package com.example.recycleviewadapter;

public class DetailList {

    private String home;
    private String add;
    private int number;

    public DetailList(String home, String add, int number) {
        this.home = home;
        this.add = add;
        this.number = number;
    }

    public DetailList(String aaa, String bbb, String ccc) {
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
