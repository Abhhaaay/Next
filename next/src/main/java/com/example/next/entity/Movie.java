package com.example.next.entity;

import java.util.List;

import jakarta.persistence.*;

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
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Image> images;

    public Movie() {
    }

    public Movie(Long id, String title, Double price, String vendor, int rating, List<Image> images) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.vendor = vendor;
        this.rating = rating;
        this.images = images;
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

    public List<Image> getImages(){
        return images;
    }

    public void setImages(List<Image> images){
        this.images = images;
    }
}
