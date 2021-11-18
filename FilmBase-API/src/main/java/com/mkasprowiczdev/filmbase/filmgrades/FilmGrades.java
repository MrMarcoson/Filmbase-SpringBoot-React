package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.user.User;

import javax.persistence.*;

@Entity(name = "filmgrades")
public class FilmGrades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "film")
    private Film film;

    private int grade;

    public FilmGrades() {
    }

    public FilmGrades(long id, User user, Film film, int grade) {
        Id = id;
        this.user = user;
        this.film = film;
        this.grade = grade;
    }

    public FilmGrades(User user, Film film, int grade) {
        this.user = user;
        this.film = film;
        this.grade = grade;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
