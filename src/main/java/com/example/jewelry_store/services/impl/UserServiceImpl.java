package com.example.jewelry_store.services.impl;//package com.example.liquor_store.services.impl;

import com.example.jewelry_store.config.PasswordEncoderUtil;
import com.example.jewelry_store.entity.User;
import com.example.jewelry_store.pojo.UserPojo;
import com.example.jewelry_store.repository.RoleRepository;
import com.example.jewelry_store.repository.UserRepository;
import com.example.jewelry_store.services.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserPojo save(UserPojo userPojo) throws IOException {

        User user = new User();
        user.setEmail(userPojo.getEmail());
        user.setFirstName(userPojo.getFirstName());
        user.setLastName(userPojo.getLastName());
        user.setPassword(PasswordEncoderUtil.getInstance().encode(userPojo.getPassword()));


        userRepository.save(user);
        return new UserPojo(user);
    }

    @Override
    public User fetchById(Integer id) {
        return null;
    }
}
