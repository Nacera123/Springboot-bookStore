package com.bookStore.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

import jakarta.persistence.Table;



@Entity
@Table(name = "MyBooks")
public class MyBookList {


    @Id
    @Column
    private int id;
    private String name;
    private String author;
    private float price;


    public MyBookList(int id, String name, String author, float price) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public MyBookList(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
