package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.LinkedList;

public interface FilmGradesRepository extends JpaRepository<FilmGrades, Long> {

    LinkedList<FilmGrades> findByFilm(Film film);
}
