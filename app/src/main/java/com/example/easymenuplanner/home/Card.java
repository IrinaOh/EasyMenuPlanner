package com.example.easymenuplanner.home;

public class Card {
    String date, description, tag;
    int image;

    public Card(String date, String description, String tag, int image) {
        this.date = date;
        this.description = description;
        this.tag = tag;
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
