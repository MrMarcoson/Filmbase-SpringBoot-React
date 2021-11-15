package com.mkasprowiczdev.filmbase.film;

import com.mkasprowiczdev.filmbase.actor.Actor;
import com.mkasprowiczdev.filmbase.actor.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    @Autowired
    ActorRepository actorRepository;

    public LinkedList<Film> getFilms()
    {
        LinkedList<Film> films = new LinkedList<>();
        filmRepository.findAll().forEach(films::add);
        return films;
    }

    public Optional<Film> getFilm(long Id){
        return filmRepository.findById(Id);
    }

    public void addFilm(Film film){
        filmRepository.save(film);
    }
}
