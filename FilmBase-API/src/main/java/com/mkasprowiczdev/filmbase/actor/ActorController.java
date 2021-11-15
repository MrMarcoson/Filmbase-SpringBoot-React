package com.mkasprowiczdev.filmbase.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.Optional;

@RestController
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/api/actor")
    public LinkedList<Actor> getActors() {
        return actorService.getActors();
    }

    @GetMapping("/api/actor/{id}")
    public Optional<Actor> getActor(long Id) {
        return actorService.getActor(Id);
    }

    @PostMapping(value = "/api/actor/{actor}")
    public void addActor(@RequestBody Actor actor) {
        actorService.addActor(actor);
    }
}
