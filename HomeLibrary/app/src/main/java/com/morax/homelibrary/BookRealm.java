package com.morax.homelibrary;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;


public class BookRealm extends RealmObject {
    private String title;
    private String author;
    private String publisher;
    private double page;
    private Date date;
    private String description;
    private int image;
    @Ignore
    private int sesionID;
    //geters and seters
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public double getPage() {
        return page;
    }

    public void setPage(double page) {
        this.page = page;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSesionID() {
        return sesionID;
    }

    public void setSesionID(int sesionID) {
        this.sesionID = sesionID;
    }




}
