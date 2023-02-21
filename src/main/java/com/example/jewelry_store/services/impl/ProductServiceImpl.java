package com.example.jewelry_store.services.impl;

import com.example.jewelry_store.entity.Product;
import com.example.jewelry_store.repository.ProductRepository;
import com.example.jewelry_store.services.CategoryService;
import com.example.jewelry_store.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor

public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    @Override
//    public ProductPojo save(ProductPojo productPojo) throws IOException {
//        Product product;
//        if (productPojo.getId()!=null){
//            product=productRepository.findById(productPojo.getId()).orElseThrow(() -> new RuntimeException("Not Found"));
//        }else{
//            product=new Product();
//        }
//        product.setName(productPojo.getName());
//        product.setCategory(categoryService.fetchById(product.getCategory().getId()));
//        product.setPrice(productPojo.getPrice());
//        product.setDescription(productPojo.getDescription());
//        product.setImageName(productPojo.getImageName());
//        productRepository.save(product);
//        return new ProductPojo(product);
//
//    }
    public void save(Product product){
        productRepository.save(product);
    }


    public List<Product> fetchAll() {
        return productRepository.findAll();
    }

//    for search
//    public List<Product> getProductByKeyword(String keyword) {
//        if (keyword!=null){
//            return productRepository.findByKeyWord(keyword);
//        }else {
//            return productRepository.findAll();
//        }
//    }

    public Product fetchById(Integer id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProductByCategoryId(int id) {
        return productRepository.findAllByCategory_Id(id);
    }

//    public List<Product> getProductByKeyword(String keyword) {
//        return productRepository.findByKeyWord(keyword);
//    }


}
