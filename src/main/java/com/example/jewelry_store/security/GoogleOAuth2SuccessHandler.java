package com.example.jewelry_store.security;

import com.example.jewelry_store.entity.Role;
import com.example.jewelry_store.entity.User;
import com.example.jewelry_store.repository.RoleRepository;
import com.example.jewelry_store.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuth2SuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

//    internally redirect
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Override
//    Servlet: core level technology that works on internet
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token=(OAuth2AuthenticationToken) authentication;
        String email=token.getPrincipal().getAttributes().get("email").toString();
        if (userRepository.findUserByEmail(email).isPresent()){
        }else{
            User user=new User();
            user.setFirstName(token.getPrincipal().getAttributes().get("family_name").toString());
            user.setLastName(token.getPrincipal().getAttributes().get("family_name").toString()); //family_name provide last name by google
            user.setEmail(email);
            List<Role> roles=new ArrayList<>();
            roles.add(roleRepository.findById(2).get()); //user role
            user.setRoles(roles);
            userRepository.save(user);
        }
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse,"/");
    }
}
