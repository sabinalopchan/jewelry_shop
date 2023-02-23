package com.example.jewelry_store.repository;

import com.example.jewelry_store.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query(value = "select * from users where email=?1",nativeQuery = true)
    Optional<User>findUserByEmail(String email);

//    @Modifying
//    @Query(value = "insert into users_roles(user_id,role_id) values(?1)",nativeQuery = true)
//    void insertUserRole(Integer u_id);
}
//    User findByUsername(String username)
