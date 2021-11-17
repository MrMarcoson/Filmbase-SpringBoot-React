package com.mkasprowiczdev.filmbase.filmgrades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/film/grades")
public class FilmGradesController {

    @Autowired
    FilmGradesService filmGradesService;

    @GetMapping("/{filmId}")
    LinkedList<FilmGrades> getFilmGrades(@PathVariable long filmId) {
        return filmGradesService.getFilmGrades(filmId);
    };

    @GetMapping("/all")
    LinkedList<FilmGrades> getFilmsWithGradesAVG() {
        return filmGradesService.getFilmsWithGradesAVG();
    };

    @PostMapping(value = "/addGrade/{filmId}/{userId}/{grade}")
    void addGrade(@PathVariable long filmId, @PathVariable long userId, @PathVariable int grade) {
        filmGradesService.addGradeToFilm(filmId, userId, grade);
    }
}
