package com.mkasprowiczdev.filmbase.filmcast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/film/cast")
public class FilmCastController {

    @Autowired
    FilmCastService filmCastService;

    @GetMapping("/all")
    public LinkedList<FilmCast> getFilmsCast() {
        return filmCastService.getFilmsCast();
    }

    @GetMapping("/{filmId}")
    public LinkedList<FilmCast> getFilmCast(@PathVariable long filmId) {
        return filmCastService.getFilmCast(filmId);
    }

    @PostMapping(value = "/addActor/{filmId}/{actorId}/{roleName}")
    public void addActorToFilmCast(@PathVariable long filmId, @PathVariable long actorId, @PathVariable String roleName) {
        filmCastService.addActorToFilmCast(filmId, actorId, roleName);
    }

    // TODO: 15.11.2021 put, delete, select by actorid 
}
