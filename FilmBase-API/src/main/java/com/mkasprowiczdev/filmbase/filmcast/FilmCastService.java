package com.mkasprowiczdev.filmbase.filmcast;

import com.mkasprowiczdev.filmbase.actor.Actor;
import com.mkasprowiczdev.filmbase.film.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class FilmCastService {

    @Autowired
    FilmCastRepository filmCastRepository;

    public LinkedList<FilmCast> getFilmsCast() {
        LinkedList<FilmCast> filmsCast = new LinkedList<>();
        filmCastRepository.findAll().forEach(filmsCast::add);
        return filmsCast;
    }

    public LinkedList<FilmCast> getFilmCast(Film film) {
        return filmCastRepository.findByFilm(film);
    }

    public void addActorToFilmCast(Film film, Actor actor, String roleName) {
        filmCastRepository.save(new FilmCast(film, actor, roleName));
    }
}
