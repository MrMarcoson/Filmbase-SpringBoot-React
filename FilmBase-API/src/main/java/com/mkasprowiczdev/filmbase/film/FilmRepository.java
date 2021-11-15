package com.mkasprowiczdev.filmbase.film;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

    Film findById(long Id);
}
