package com.example.jewelry_store.repository;

import com.example.jewelry_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User>findUserByEmail(String email);
//    User findByUsername(String username);
}
