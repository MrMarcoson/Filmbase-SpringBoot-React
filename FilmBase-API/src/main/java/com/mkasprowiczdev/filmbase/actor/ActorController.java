package com.mkasprowiczdev.filmbase.actor;

import com.mkasprowiczdev.filmbase.actor.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.Optional;

@RestController
@RequestMapping("/api/actor")
public class ActorController {

    @Autowired
    ActorService actorService;

    @GetMapping("/all")
    public LinkedList<Actor> getActors() {
        return actorService.getActors();
    }
    
    @GetMapping("/{id}")
    public Actor getActor(long Id) {
        return actorService.getActor(Id);
    }

    @PostMapping("/add")
    public void addActor(@RequestBody Actor actor) {
        actorService.addActor(actor);
    }

    // TODO: 15.11.2021 put and delete 
}
