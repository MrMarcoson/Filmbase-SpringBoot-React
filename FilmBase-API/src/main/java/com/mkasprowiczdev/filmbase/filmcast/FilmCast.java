package com.mkasprowiczdev.filmbase.filmcast;

import com.mkasprowiczdev.filmbase.actor.Actor;
import com.mkasprowiczdev.filmbase.film.Film;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class FilmCast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    private String roleName;

    public FilmCast() {
    }

    public FilmCast(Film film, Actor actor, String roleName) {
        this.film = film;
        this.actor = actor;
        this.roleName = roleName;
    }

    public FilmCast(long id, Film film, Actor actor, String roleName) {
        Id = id;
        this.film = film;
        this.actor = actor;
        this.roleName = roleName;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
