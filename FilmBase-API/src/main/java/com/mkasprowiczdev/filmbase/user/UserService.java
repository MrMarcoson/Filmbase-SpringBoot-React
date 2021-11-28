package com.mkasprowiczdev.filmbase.user;

import com.mkasprowiczdev.filmbase.filmgrades.FilmGrades;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    LinkedList<User> getUsers() {
        LinkedList<User> users = new LinkedList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public User getUser(long Id) {
        return userRepository.findById(Id);
    }

    public User getUser(String login, String password) {
        return userRepository.findByUsernameAndPassword(login, password);
    }

    void addUser(User user) {
        userRepository.save(user);
    }

    void addFilmGrade(User user, FilmGrades filmGrades) {

    }
}
