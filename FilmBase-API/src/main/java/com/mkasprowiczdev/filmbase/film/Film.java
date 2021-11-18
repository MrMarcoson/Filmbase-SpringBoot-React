package com.mkasprowiczdev.filmbase.film;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkasprowiczdev.filmbase.filmcast.FilmCast;
import com.mkasprowiczdev.filmbase.filmgrades.FilmGrades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String title;
    private int premiereDate;
    private String description;
    private double avgGrade;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private Set<FilmCast> filmCast = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private Set<FilmGrades> filmGrade = new HashSet<>();

    public Film() {
    }

    public Film(String title, int premiereDate, String description) {
        this.title = title;
        this.premiereDate = premiereDate;
        this.description = description;
    }

    public Film(String title, int premiereDate, String description, Set<FilmCast> filmCast, Set<FilmGrades> filmGrade, double avgGrade) {
        this.title = title;
        this.premiereDate = premiereDate;
        this.description = description;
        this.filmCast = filmCast;
        this.filmGrade = filmGrade;
        this.avgGrade = avgGrade;
    }

    public Film(String title, int premiereDate, String description, Set<FilmCast> filmCast, Set<FilmGrades> filmGrade) {
        this.title = title;
        this.premiereDate = premiereDate;
        this.description = description;
        this.filmCast = filmCast;
        this.filmGrade = filmGrade;
        this.avgGrade = 0;
    }

    public Film(long id, String title, int premiereDate, String description, double avgGrade, Set<FilmCast> filmCast, Set<FilmGrades> filmGrade) {
        Id = id;
        this.title = title;
        this.premiereDate = premiereDate;
        this.description = description;
        this.avgGrade = avgGrade;
        this.filmCast = filmCast;
        this.filmGrade = filmGrade;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(int premiereDate) {
        this.premiereDate = premiereDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<FilmCast> getFilmCast() {
        return filmCast;
    }

    public void setFilmCast(Set<FilmCast> filmCast) {
        this.filmCast = filmCast;
    }

    public Set<FilmGrades> getFilmGrade() {
        return filmGrade;
    }

    public void setFilmGrade(Set<FilmGrades> filmGrade) {
        this.filmGrade = filmGrade;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}
