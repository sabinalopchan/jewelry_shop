package com.example.jewelry_store.repository;

import com.example.jewelry_store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product, Integer> {
    List<Product> findAllByCategory_Id(int id);

//    @Query("SELECT p FROM product p WHERE p.name LIKE %:keyword% OR p.price LIKE %:keyword%")
//    @Query (value = "select * from product p where p.name like %:keywords% or  p.price like %:keywords", nativeQuery = true)
//    List<Product> findByKeyWord(@Param("keyword") String keyword);
}
