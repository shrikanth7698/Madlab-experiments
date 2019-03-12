package me.shrikanthravi.madlab.data.models;

public class Experiment {
    String number="";
    String title="";

    public Experiment(String number,String title) {
        this.number = number;
        this.title = title;
    }

    public Experiment() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
