package com.mkasprowiczdev.filmbase.film;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findById(long Id);

    @Modifying
    @Query("UPDATE film f set f.avgGrade = :avg WHERE f.id = :filmId")
    void setFilmAVG(@Param("filmId") long filmId, @Param("avg") double avg);
}
