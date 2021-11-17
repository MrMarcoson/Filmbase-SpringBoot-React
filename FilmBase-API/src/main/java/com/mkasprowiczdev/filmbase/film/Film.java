package com.mkasprowiczdev.filmbase.film;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkasprowiczdev.filmbase.filmcast.FilmCast;
import com.mkasprowiczdev.filmbase.filmgrades.FilmGrades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Title;
    private int PremiereDate;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private Set<FilmCast> filmCast = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "film")
    private Set<FilmGrades> filmGrade = new HashSet<>();

    public Film() {
    }

    public Film(String title, int premiereDate, String description) {
        Title = title;
        PremiereDate = premiereDate;
        this.description = description;
    }

    public Film(String title, int premiereDate, String description, Set<FilmCast> filmCast, Set<FilmGrades> filmGrade) {
        Title = title;
        PremiereDate = premiereDate;
        this.description = description;
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
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getPremiereDate() {
        return PremiereDate;
    }

    public void setPremiereDate(int premiereDate) {
        PremiereDate = premiereDate;
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
}
