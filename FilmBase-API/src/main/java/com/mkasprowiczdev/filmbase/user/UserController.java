package com.mkasprowiczdev.filmbase.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    LinkedList<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{Id}")
    User getUser(@PathVariable long Id) {
        return userService.getUser(Id);
    }

    @GetMapping("/{login}/{password}")
    User getUser(@PathVariable  String login, @PathVariable String password) {
        return userService.getUser(login, password);
    }

    @PostMapping("/add")
    void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    // TODO: 15.11.2021 put, delete, change adding film grades
}
