package com.example.jewelry_store.controller;

import com.example.jewelry_store.entity.Category;
import com.example.jewelry_store.entity.Product;
import com.example.jewelry_store.pojo.CategoryPojo;
import com.example.jewelry_store.pojo.ProductPojo;
import com.example.jewelry_store.services.CategoryService;
import com.example.jewelry_store.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminController {
//    System provide various properties
    public static String uploadDir=System.getProperty("user.dir") + "/src/main/resources/static/productImages";
//    @Autowired
//    CategoryServiceImpl categoryService;
    private final CategoryService categoryService;
    @Autowired
    private final ProductService productService;
    @GetMapping("/admin")
    public String dashboard(){
        return "backend/dashboard";
    }

    @GetMapping("/admin/index")
    public String adminDas(){
        return "backend/dashboard";
    }

    @GetMapping("/admin/category")
    public String getCategory(Model model){
        List<Category> categories=categoryService.fetchAll();
        model.addAttribute("categories", categories.stream().map(category ->
                Category.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .build()
                ));
        return "backend/category/index_category";

    }

    @GetMapping("/admin/add_category")
    public String getCategoryAdd(Model model){
        model.addAttribute("category", new CategoryPojo());
        return "backend/category/add_category";
    }
    @PostMapping("/admin/add_category")
    public String addCategory(@Valid CategoryPojo categoryPojo,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) throws IOException {

        Map<String, String> requestError = validateRequest(bindingResult);
        if (requestError != null) {
            redirectAttributes.addFlashAttribute("requestError", requestError);
            return "redirect:admin/add_category";
        }

        categoryService.save(categoryPojo);
        redirectAttributes.addFlashAttribute("successMsg", "Category saved successfully");


        return "redirect:/admin/category";
    }

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
    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        categoryService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Category deleted successfully");
        return "redirect:/admin/category";
    }

    @GetMapping ("/admin/category/update/{id}")
    public String updateCategory(@PathVariable("id") int id, Model model){
        Category category=categoryService.fetchById(id);
        model.addAttribute("category",new CategoryPojo(category));
        return "backend/category/edit_category";
    }

    @PostMapping("/admin/category/update/{id}")
    public String updateCategoryPost(@PathVariable("id") int id, @ModelAttribute("category") Category category, Model model){
        Category category1=categoryService.fetchById(id);
        category1.setId(id);
        category1.setName(category.getName());

        categoryService.updateCategory(category1);
        return "redirect:/admin/category";
    }

//        Product Section

    @GetMapping("/admin/product")
    public String getProduct(Model model){
        List<Product> products=productService.fetchAll();
        model.addAttribute("products", products.stream().map(product ->
                Product.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .category(product.getCategory())
                        .price(product.getPrice())
                        .description(product.getDescription())
                        .imageName(product.getImageName())
                        .build()
        ));
        return "backend/product/index_product";
    }

    @GetMapping("/admin/add_product")
    public String productAddGet(Model model){
        model.addAttribute("product", new ProductPojo());
        model.addAttribute("categories", categoryService.fetchAll());
        return "backend/product/add_product";
    }

    @PostMapping("/admin/add_product")
    public String productAddPost(@ModelAttribute("product") ProductPojo productPojo,
                                 @RequestParam("productImage")MultipartFile file,
                                 @RequestParam("imgName") String imgName) throws IOException{

        Product product=new Product();
        product.setId(productPojo.getId());
        product.setName(productPojo.getName());
        product.setCategory(categoryService.fetchById(productPojo.getCategoryId()));
        product.setPrice(productPojo.getPrice());
        product.setDescription(productPojo.getDescription());
        String imageUUID;
        if (!file.isEmpty()){
            imageUUID=file.getOriginalFilename();
            Path fileNameAndPath= Paths.get(uploadDir, imageUUID);
            Files.write(fileNameAndPath, file.getBytes());
        }else{
            imageUUID=imgName;
        }
        product.setImageName(imageUUID);
        productService.save(product);

        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, RedirectAttributes redirectAttributes){
        productService.deleteById(id);
        redirectAttributes.addFlashAttribute("deleteMsg", "Product deleted successfully");
        return "redirect:/admin/product";
    }

    @GetMapping ("/admin/product/update/{id}")
    public String updateProduct(@PathVariable("id") int id, Model model){
        Product product=productService.fetchById(id);
        ProductPojo productPojo=new ProductPojo();
        productPojo.setId(product.getId());
        productPojo.setName(product.getName());
        productPojo.setCategoryId(productPojo.getCategoryId());
        productPojo.setPrice(productPojo.getPrice());
        productPojo.setDescription(productPojo.getDescription());
        productPojo.setImageName(productPojo.getImageName());
        model.addAttribute("categories", categoryService.fetchAll());
        model.addAttribute("product", productPojo);
        return "backend/product/add_product";
    }


}


