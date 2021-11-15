package com.mkasprowiczdev.filmbase.actor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    ActorRepository actorRepository;

    public LinkedList<Actor> getActors() {
        LinkedList<Actor> actors = new LinkedList<>();
        actors.addAll(actorRepository.findAll());
        return actors;
    }

    public Actor getActor(long Id) {
        return actorRepository.findById(Id);
    }

    public void addActor(Actor actor) {
        actorRepository.save(actor);
    }
}
