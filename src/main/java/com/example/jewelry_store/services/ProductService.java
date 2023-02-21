package com.example.jewelry_store.services;

import com.example.jewelry_store.entity.Product;

import java.util.List;

public interface ProductService {
//    ProductPojo save(ProductPojo productPojo) throws IOException;
    void save(Product product);
    List<Product> fetchAll();
//    List<Product> getProductByKeyword(String keyword);

    Product fetchById(Integer id);

    void deleteById(Integer id);

    List<Product> getAllProductByCategoryId(int id);


}
