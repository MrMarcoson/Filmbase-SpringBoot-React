package com.mkasprowiczdev.filmbase;

import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.film.FilmController;
import com.mkasprowiczdev.filmbase.film.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmbaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmbaseApplication.class, args);
	}
}
