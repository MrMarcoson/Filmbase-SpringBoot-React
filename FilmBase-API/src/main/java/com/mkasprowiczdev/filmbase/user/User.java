package com.mkasprowiczdev.filmbase.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.filmgrades.FilmGrades;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    private String username;
    private String password;
    private String email;

    //films values
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    Set<FilmGrades> filmGrades = new HashSet<>();

    public User() {
    }

    public User(long id, String username, String password, String email, Set<FilmGrades> filmGrades) {
        Id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.filmGrades = filmGrades;
    }

    public User(String username, String password, String email, Set<FilmGrades> filmGrades) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.filmGrades = filmGrades;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<FilmGrades> getFilmGrades() {
        return filmGrades;
    }

    public void setFilmGrades(Set<FilmGrades> filmGrades) {
        this.filmGrades = filmGrades;
    }
}
