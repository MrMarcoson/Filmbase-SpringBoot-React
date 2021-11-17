package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.film.FilmService;
import com.mkasprowiczdev.filmbase.user.User;
import com.mkasprowiczdev.filmbase.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class FilmGradesService {

    @Autowired
    FilmGradesRepository filmGradesRepository;

    @Autowired
    FilmService filmService;

    @Autowired
    UserService userService;

    //todo check if it can be done to search by filmId in filmGrades table (many to many table)
    public LinkedList<FilmGrades> getFilmGrades(long filmId) {
        Film film = filmService.getFilm(filmId);
        return filmGradesRepository.findByFilm(film);
    }

    //to create ranking of movies todo make some kind of range (top 100 movies etc)
    public LinkedList<FilmGrades> getFilmsWithGradesAVG() {
        return filmGradesRepository.findAllWithGradeAVG();
    }

    public LinkedList<FilmGrades> getFilmWithGradesAVG(long filmId) {
        Film film = filmService.getFilm(filmId);
        return filmGradesRepository.findFilmWithGradeAVG(film);
    }

    public void addGradeToFilm(long filmId, long userId, int grade) {
        Film film = filmService.getFilm(filmId);
        User user = userService.getUser(userId);
        filmGradesRepository.save(new FilmGrades(user, film, grade));
    }
}
