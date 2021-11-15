package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmGradesService {

    @Autowired
    FilmGradesRepository filmGradesRepository;

    public FilmGrades getFilmGrades(Film film) {
        return filmGradesRepository.findByFilm(film);
    }

    public void addFilmGrade(User user, Film film, int grade) {
        filmGradesRepository.save(new FilmGrades(user, film, grade));
    }
}
