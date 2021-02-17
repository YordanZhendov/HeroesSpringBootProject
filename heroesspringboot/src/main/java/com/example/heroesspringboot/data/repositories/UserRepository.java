package com.example.heroesspringboot.data.repositories;

import com.example.heroesspringboot.data.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
