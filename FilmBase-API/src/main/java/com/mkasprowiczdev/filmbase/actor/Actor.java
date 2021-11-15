package com.mkasprowiczdev.filmbase.actor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.filmcast.FilmCast;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Actor {

    enum genderType {
        MALE, FEMALE, OTHER;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String Name;
    private String SecondName;
    private int DateOfBirth;
    private String PlaceOfBirth;
    private genderType Gender;

    @OneToMany(mappedBy = "film")
    private Set<FilmCast> filmCast = new HashSet<>();

    public Actor() {
    }

    public Actor(long id, String name, String secondName, int dateOfBirth, String placeOfBirth, genderType gender, Set<FilmCast> filmCast) {
        Id = id;
        Name = name;
        SecondName = secondName;
        DateOfBirth = dateOfBirth;
        PlaceOfBirth = placeOfBirth;
        Gender = gender;
        this.filmCast = filmCast;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSecondName() {
        return SecondName;
    }

    public void setSecondName(String secondName) {
        SecondName = secondName;
    }

    public int getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getPlaceOfBirth() {
        return PlaceOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        PlaceOfBirth = placeOfBirth;
    }

    public genderType getGender() {
        return Gender;
    }

    public void setGender(genderType gender) {
        Gender = gender;
    }

    public Set<FilmCast> getFilmCast() {
        return filmCast;
    }

    public void setFilmCast(Set<FilmCast> filmCast) {
        this.filmCast = filmCast;
    }
}
