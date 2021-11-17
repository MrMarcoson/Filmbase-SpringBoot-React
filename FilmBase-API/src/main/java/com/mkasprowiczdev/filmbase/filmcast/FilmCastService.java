package com.mkasprowiczdev.filmbase.filmcast;

import com.mkasprowiczdev.filmbase.actor.Actor;
import com.mkasprowiczdev.filmbase.actor.ActorService;
import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class FilmCastService {

    @Autowired
    FilmCastRepository filmCastRepository;

    //to get film and actor by id
    @Autowired
    FilmService filmService;

    @Autowired
    ActorService actorService;

    public LinkedList<FilmCast> getFilmsCast() {
        LinkedList<FilmCast> filmsCast = new LinkedList<>(filmCastRepository.findAll());
        return filmsCast;
    }

    public LinkedList<FilmCast> getFilmCast(long filmId) {
        Film film = filmService.getFilm(filmId);
        return filmCastRepository.findByFilm(film);
    }

    public void addActorToFilmCast(long filmId, long actorId, String roleName) {
        Film film = filmService.getFilm(filmId);
        Actor actor = actorService.getActor(actorId);
        filmCastRepository.save(new FilmCast(film, actor, roleName));
    }
}
