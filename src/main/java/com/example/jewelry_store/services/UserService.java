package com.example.jewelry_store.services;//package com.example.liquor_store.services;

import com.example.jewelry_store.entity.User;
import com.example.jewelry_store.pojo.UserPojo;

import java.io.IOException;
import java.util.Optional;

public interface UserService {
    UserPojo save(UserPojo userPojo) throws IOException;

    User fetchById(Integer id);

}
