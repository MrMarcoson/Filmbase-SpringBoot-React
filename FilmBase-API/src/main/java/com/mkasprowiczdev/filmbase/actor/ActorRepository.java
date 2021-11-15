package com.mkasprowiczdev.filmbase.actor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    Actor findById(long Id);
}
