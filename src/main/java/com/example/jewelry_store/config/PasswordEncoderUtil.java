package com.example.jewelry_store.config;//package com.example.liquor_store.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    private static BCryptPasswordEncoder encoder;

    public static BCryptPasswordEncoder getInstance(){
        return encoder;
    }
}
