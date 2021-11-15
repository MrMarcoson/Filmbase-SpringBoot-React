package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmGradesRepository extends JpaRepository<FilmGrades, Long> {

    FilmGrades findByFilm(Film film);
}
