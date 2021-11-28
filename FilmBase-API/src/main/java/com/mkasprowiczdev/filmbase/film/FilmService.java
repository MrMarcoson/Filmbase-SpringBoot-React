package com.mkasprowiczdev.filmbase.film;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;

@Service
public class FilmService {

    @Autowired
    FilmRepository filmRepository;

    public LinkedList<Film> getFilms()
    {
        return new LinkedList<>(filmRepository.findAll());
    }

    public Film getFilm(long Id){
        return filmRepository.findById(Id);
    }

    public LinkedList<Film> getFilmByTitle(String title) {
        return filmRepository.findByTitle(title);
    }

    public Integer getRankingPagesNum() {
        Pageable sortedByAVGGrade = PageRequest.of(0, 20, Sort.by("avgGrade").descending());
        Page<Film> filmPage = filmRepository.findAll(sortedByAVGGrade);
        return filmPage.getTotalPages();
    }

    public LinkedList<Film> getFilmRanking(int page) {
        Pageable sortedByAVGGrade = PageRequest.of(page, 20, Sort.by("avgGrade").descending());
        Page<Film> filmPage = filmRepository.findAll(sortedByAVGGrade);

        LinkedList<Film> films = new LinkedList<>();
        films.addAll(filmPage.getContent());

        return films;
    }

    public void addFilm(Film film){
        filmRepository.save(film);
    }

    @Transactional
    public void setFilmAVG(long filmId, double avg) {
        filmRepository.setFilmAVG(filmId, avg);
    }
}
