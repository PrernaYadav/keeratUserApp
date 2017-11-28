package com.example.user10.keerat.activity.model;

/**
 * Created by designer on 11/25/2017.
 */

public class BookProgramModel {
    String available;
    String providername;
   // Float rating;
    int image;


    public BookProgramModel(String available, String providername, int image) {
        this.available = available;
        this.providername = providername;
        this.image = image;
    }

    public String getAvailable() {
        return available;
    }

    public String getProvidername() {
        return providername;
    }

    public int getImage() {
        return image;
    }
}
