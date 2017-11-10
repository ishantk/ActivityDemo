package com.auribises.activitydemo;

/**
 * Created by ishantkumar on 10/11/17.
 */

public class NewsModel {

    // Attributes
    int image;
    String name;
    String description;

    public NewsModel(){

    }

    public NewsModel(int image, String name, String description) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
