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

    public double calculateAVG(LinkedList<FilmGrades> filmGrades) {
        double grade = 0;

        for (FilmGrades filmGrade : filmGrades) {
            grade += filmGrade.getGrade();
        }

        return grade / filmGrades.size();
    }

    public void setNewAVG(Film film) {
        LinkedList<FilmGrades> filmGrades = filmGradesRepository.findByFilm(film);
        filmService.setFilmAVG(film.getId(), calculateAVG(filmGrades));
    }

    public LinkedList<FilmGrades> getFilmGrades(long filmId) {
        Film film = filmService.getFilm(filmId);
        return filmGradesRepository.findByFilm(film);
    }
/*
    public Film getFilmGradesAVG(long filmId) {
        Film film = filmService.getFilm(filmId);
        LinkedList<FilmGrades> filmGrades = filmGradesRepository.findByFilm(film);
        film.setAvgGrade(calculateAVG(filmGrades));
    }
*/
    //When grade is added, program calculates new film avg
    public void addGradeToFilm(long filmId, long userId, int grade) {
        Film film = filmService.getFilm(filmId);
        User user = userService.getUser(userId);
        filmGradesRepository.save(new FilmGrades(user, film, grade));
        setNewAVG(film);
    }
}
