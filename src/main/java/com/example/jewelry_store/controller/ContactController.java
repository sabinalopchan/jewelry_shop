package com.example.jewelry_store.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {
    @GetMapping("/user/contact")
    public String contact(){
        return "contact";
    }
}
