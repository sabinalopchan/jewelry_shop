package com.example.jewelry_store.repository;

import com.example.jewelry_store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

//provides basics methods to save in database
public interface CategoryRepository extends JpaRepository <Category, Integer>{

}
