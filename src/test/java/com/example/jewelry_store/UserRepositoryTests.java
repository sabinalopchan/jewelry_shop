package com.example.jewelry_store;//package com.example.liquor_store;

import com.example.jewelry_store.entity.User;
import com.example.jewelry_store.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUserTest() {
        User user = new User();
        user.setFirstName("sabina");
        user.setLastName("lopchan");
        user.setEmail("abc@gmail.com");
        user.setPassword("abcde");

        userRepository.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);
    }
}