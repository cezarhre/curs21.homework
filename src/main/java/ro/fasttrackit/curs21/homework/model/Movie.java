package ro.fasttrackit.curs21.homework.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int year;

    @OneToOne(cascade = CascadeType.ALL)
    private MovieRating rating;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Review> review;

    @ManyToOne
    private Studio studio;

    @ManyToMany
    private List<Actor> actors;

    public Movie(){
    }

    public Movie(Studio studio, String name, int year, MovieRating rating, List<Review> review, List<Actor> actors) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.review = review;
        this.studio = studio;
        this.actors = actors;
    }

    public Movie(Studio studio, String name, int year, MovieRating rating, List<Review> review) {
        this(studio, name, year, rating, review, List.of());
    }

    public Movie(Studio studio, String name, int year, MovieRating rating) {
        this(studio,name, year, rating, List.of());
    }

    public Movie(Studio studio, String name, int year) {
        this(studio,name, year, null, List.of());
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

    public List<Review> getReview() {
        return review;
    }

    public void setReview(List<Review> review) {
        this.review = review;
    }

    public MovieRating getRating() {
        return rating;
    }

    public void setRating(MovieRating rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
