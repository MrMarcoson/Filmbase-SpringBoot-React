package com.mkasprowiczdev.filmbase.filmgrades;

import com.mkasprowiczdev.filmbase.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedList;

public interface FilmGradesRepository extends JpaRepository<FilmGrades, Long> {

    LinkedList<FilmGrades> findByFilm(Film film);

    @Query(value = "SELECT film, AVG(grade) FROM FilmGrades")
    LinkedList<FilmGrades> findAllWithGradeAVG();

    @Query(value = "SELECT AVG(grade) FROM FilmGrades WHERE film = :film")
    LinkedList<FilmGrades> findFilmWithGradeAVG(Film film);
}
