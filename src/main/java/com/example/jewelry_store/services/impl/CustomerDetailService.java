package com.example.jewelry_store.services.impl;

import com.example.jewelry_store.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerDetailService implements UserDetailsService {

    private final UserRepository userRepo;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepo.findUserByEmail(username).orElseThrow(() -> new EntityNotFoundException("User not found."));
    }
}