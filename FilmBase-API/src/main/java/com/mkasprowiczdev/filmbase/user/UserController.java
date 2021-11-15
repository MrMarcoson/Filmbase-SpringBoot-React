package com.mkasprowiczdev.filmbase.user;

import com.mkasprowiczdev.filmbase.film.Film;
import com.mkasprowiczdev.filmbase.filmgrades.FilmGrades;
import com.mkasprowiczdev.filmbase.filmgrades.FilmGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    FilmGradesService filmGradesService;

    @GetMapping("/all")
    LinkedList<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping(value = "user")
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PostMapping("/{user}/{film}/{grade}")
    void addFilmGrade(@RequestBody User user, @RequestBody Film film, @RequestBody int grade) {
        filmGradesService.addFilmGrade(user, film, grade);
    }
}
