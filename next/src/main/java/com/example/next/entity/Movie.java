package com.example.next.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private Long id;
    private String title;
    private Double price;
    private String vendor;
    private int rating;
    private String poster_urls;

    public Movie() {
    }

    public Movie(Long id, String title, Double price, String vendor, int rating, String poster_urls) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.vendor = vendor;
        this.rating = rating;
        this.poster_urls = poster_urls;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    public String getPosterUrls(){
        return poster_urls;
    }

    public void setPosterUrls(String poster_urls){
        this.poster_urls = poster_urls;
    }
}
