package com.mkasprowiczdev.filmbase.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long Id);

    User findByUsernameAndPassword(String login, String password);
}
