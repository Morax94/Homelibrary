package com.morax.homelibrary;
public class Book {


    private String title;
    private String author;
    private String publisher;
    private double numberofpage;
    private String description;
    private String date;
    private String image;

    public Book(String title,String author, String publisher, double numberofpage, String description,String date, String image){
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

    public String getImage() {
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
