package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/film/grades")
public class FilmGradesController {

    @Autowired
    FilmGradesService filmGradesService;

    @PostMapping(value = "/addGrade/{filmId}/{userId}/{grade}")
    void addGrade(@PathVariable long filmId, @PathVariable long userId, @PathVariable int grade) {
        filmGradesService.addGradeToFilm(filmId, userId, grade);
    }
}
