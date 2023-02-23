package com.example.jewelry_store.controller;

import com.example.jewelry_store.services.CategoryService;
import com.example.jewelry_store.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping({"/category/{id}", "/home/category/{id}"})
    public String shopByCategory(Model model, @PathVariable int id){
        model.addAttribute("categories", categoryService.fetchAll());
        model.addAttribute("products", productService.getAllProductByCategoryId(id));
        return "index";
    }

    @GetMapping({"/productDetails/{id}", "/home/productDetails/{id}"})
    public String viewProduct(Model model, @PathVariable int id){
        model.addAttribute("product", productService.fetchById(id));
        return "productDetails";
    }

//    @GetMapping({"/search","/home/search"})
//    public String search(Model model, String keyword){
//        if (keyword!=null){
////            model.addAttribute("categories", categoryService.fetchAll());
//            model.addAttribute("search",productService.getProductByKeyword(keyword));
//        }else {
//            model.addAttribute("categories", categoryService.fetchAll());
//            model.addAttribute("products", productService.fetchAll());
//
//        }
//        return "search";
//    }
//




}
