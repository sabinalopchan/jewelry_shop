package com.example.jewelry_store.services;

import com.example.jewelry_store.entity.Category;
import com.example.jewelry_store.pojo.CategoryPojo;

import java.io.IOException;
import java.util.List;

public interface CategoryService {
    CategoryPojo save(CategoryPojo categoryPojo) throws IOException;

    List<Category> fetchAll();

    Category fetchById(Integer id);

    void deleteById(Integer id);

    Category updateCategory(Category category);


}
