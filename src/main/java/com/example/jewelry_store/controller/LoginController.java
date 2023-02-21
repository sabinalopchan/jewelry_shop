package com.example.jewelry_store.controller;


import com.example.jewelry_store.entity.Role;
import com.example.jewelry_store.entity.User;
import com.example.jewelry_store.repository.RoleRepository;
import com.example.jewelry_store.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequiredArgsConstructor
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;


    @GetMapping("/login")
    public String login(){
        return  "login";
    }

//    @GetMapping("/register")
//    public String registerGet(Model model){
//        model.addAttribute("user", new User());
//        return "register";
//    }

    @GetMapping("/register")
    public String registerGet(Model model){
        model.addAttribute("user", new User());
        return "register";    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
        String password = user.getPassword();
        if (password == null) {
            // Handle null password error
            return "redirect:/register?error=password";
        }
        String encodedPassword = bCryptPasswordEncoder.encode(password);
        user.setPassword(encodedPassword);

        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        userRepository.save(user);
//        request.login(user.getEmail(), password);

//        try {
//            request.login(user.getEmail(), password);
//        } catch (ServletException e) {
////             Handle login error
//            return "redirect:/login?error";
//
//        }
        return "redirect:/";

    }






//    @PostMapping("/register")
//    public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException{
//        String password = user.getPassword();
//        user.setPassword(bCryptPasswordEncoder.encode(password));
////        String password= bCryptPasswordEncoder.encode(userPojo.getPassword());
////        userPojo.setPassword(password);
//        List<Role> roles=new ArrayList<>();
//        roles.add(roleRepository.findById(2).get());
//        user.setRoles(roles);
//        userRepository.save(user);
//        System.out.println(user);
//
//        request.login(user.getEmail(),password);
//        return "redirect:/";
//    }
//@PostMapping("/register")
//public String createUser( @ModelAttribute("user") User user,
//                         BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException, ServletException {
//
//    Map<String, String> requestError = validateRequest(bindingResult);
//    if (requestError != null) {
//        redirectAttributes.addFlashAttribute("requestError", requestError);
//        return "redirect:/register";
//    }
////
//    String password = user.getPassword();
//    user.setPassword(bCryptPasswordEncoder.encode(password));
//    user.setPassword(password);
//    List<Role> roles=new ArrayList<>();
//    roles.add(roleRepository.findById(2).get());
//    user.setRoles(roles);
//    userRepository.save(user);
////    request.login(user.getEmail(),password);
//    redirectAttributes.addFlashAttribute("successMsg", "User saved successfully");
//
//    return "redirect:/";
//}

    public Map<String, String> validateRequest(BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            return null;
        }
        Map<String, String> errors = new HashMap<>();
        bindingResult.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });
        return errors;
    }
}

