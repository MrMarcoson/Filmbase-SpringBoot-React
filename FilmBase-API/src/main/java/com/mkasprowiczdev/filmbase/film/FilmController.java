package com.mkasprowiczdev.filmbase.film;

import com.mkasprowiczdev.filmbase.actor.Actor;
import com.mkasprowiczdev.filmbase.filmcast.FilmCast;
import com.mkasprowiczdev.filmbase.filmcast.FilmCastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Optional;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    @Autowired
    FilmCastService filmCastService;

    @GetMapping("/all")
    public LinkedList<Film> getFilms() {
        return filmService.getFilms();
    }

    @GetMapping("/{id}")
    public Optional<Film> getFilm(@PathVariable long Id) {
        return filmService.getFilm(Id);
    }

    @PostMapping
    public void addFilm(@RequestBody Film film) {
        filmService.addFilm(film);
    }

    @PostMapping("/addActor/{roleName}")
    public void addActorToFilmCast(@RequestBody Film film, @RequestBody Actor actor, @PathVariable String roleName) {
        filmCastService.addActorToFilmCast(film, actor, roleName);
    }
}
