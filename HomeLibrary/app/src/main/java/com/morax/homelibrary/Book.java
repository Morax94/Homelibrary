package com.morax.homelibrary;

import android.graphics.drawable.Drawable;

public class Book {


    private String title;
    private String author;
    private String publisher;
    private double numberofpage;
    private String description;
    private String date;
    private Integer image;

    public Book(String title,String author, String publisher, double numberofpage, String description,String date, Integer image){
        this.author = author;
        this.title = title;
        this.description=description;
        this.numberofpage=numberofpage;
        this.publisher=publisher;
        this.image=image;
        this.date=date;
    }
    public String getPublisher() {
        return publisher;
    }

    public double getNumberofpage() {
        return numberofpage;
    }

    public String getDescription() {
        return description;
    }

    public Integer getImage() {
        return image;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getDate() {
        return date;
    }
}
