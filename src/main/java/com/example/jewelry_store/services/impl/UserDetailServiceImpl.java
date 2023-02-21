package com.example.jewelry_store.services.impl;

//import com.example.liquor_store.config.PasswordEncoderUtil;

import com.example.jewelry_store.entity.CustomUserDetail;
import com.example.jewelry_store.entity.User;
import com.example.jewelry_store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
//@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(username);
//
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        for (Role role : user.getRoles()){
//            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);    }
//

        @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user=userRepository.findUserByEmail(email);
        user.orElseThrow(()->new UsernameNotFoundException("User not found"));
        return user.map(CustomUserDetail::new).get();
    }
//    public void save(User userData){
//        User user=new User();
//        user.setRole("USER");
//        user.setEmail(userData.getEmail());
//        user.setPassword(PasswordEncoderUtil.getInstance().encode(userData.getPassword()));
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findUserByEmail(username).orElseThrow(()-> new EntityNotFoundException("user not found"));
//        return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),
//                getAuthorities(user));
//
//    }

//    private static Collection<? extends GrantedAuthority> getAuthorities(User user){
//        String[] userRoles=user.getRoles().stream().map(role -> role.getName()).toArray(String[]::new);
//        Collection<GrantedAuthority> authorities= AuthorityUtils.createAuthorityList(userRoles);
//        return authorities;
//    }
}
