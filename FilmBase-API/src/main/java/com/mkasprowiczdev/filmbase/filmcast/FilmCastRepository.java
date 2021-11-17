package com.mkasprowiczdev.filmbase.filmcast;

import com.mkasprowiczdev.filmbase.film.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.LinkedList;

public interface FilmCastRepository extends JpaRepository<FilmCast, Long> {

    LinkedList<FilmCast> findByFilm(Film film);
}
