package com.example.jewelry_store.services.impl;//package com.example.liquor_store.services.impl;
//
//import com.example.liquor_store.entity.User;
//import com.example.liquor_store.repository.RoleRepository;
//import com.example.liquor_store.repository.UserRepository;
//import com.example.liquor_store.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.Optional;
//
//public class UserServiceImpl implements UserService {
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepository roleRepository;
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//    @Override
//    public void save(User user) {
////        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        user.setRoles(roleRepository.findAll());
////        user.setRoles(new HashSet<>(roleRepository.findAll()));
//
//        userRepository.save(user);
//    }
//
//    @Override
//    public Optional<User> findByUsername(String username) {
//        return userRepository.findUserByEmail(username);
//    }
//}
