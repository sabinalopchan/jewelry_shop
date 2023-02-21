package com.example.jewelry_store;//package com.example.liquor_store;
import com.example.jewelry_store.entity.Category;
import com.example.jewelry_store.entity.Product;
import com.example.jewelry_store.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;
    @Test
    public void saveProductTest(){
        Product product=Product.builder()
                .name("Ring")
                .price(400)
                .description("nice one")
                .imageName("text.jpg")
                .build();
        productRepository.save(product);
        Assertions.assertThat(product.getId()).isGreaterThan(0);
    }

    @Test
    public void updateProductTest(){

        Product product=Product.builder()
                .name("Ring")
                .price(400)
                .description("nice one")
                .imageName("text.jpg")
                .build();
        productRepository.save(product);

        Product product1 = productRepository.findById(product.getId()).get();
        product1.setName("abc");
        productRepository.save(product1);

        Assertions.assertThat(product1.getId()).isEqualTo(1);
    }

    @Test
    public void DeleteProductTest(){

        Product product=Product.builder()
                .name("Ring")
                .price(400)
                .description("nice one")
                .imageName("text.jpg")
                .build();
        productRepository.save(product);

        Product product1 = productRepository.findById(product.getId()).get();
        productRepository.delete(product1);

        Optional<Product> deletedUser = productRepository.findById(product1.getId());

        Assertions.assertThat(deletedUser.isPresent()).isEqualTo(false);
    }


























//    With object
//    @Test
//    public void saveProductTest(){
//        Category category=new Category();
//        category.setName("Test Category");
//        Product product=Product.builder()
//                .name("Ring")
//                .price(400)
//                .description("nice one")
//                .imageName("text.jpg")
//                .category(category)
//                .build();
//        assertEquals("Test Category",product.getCategory().getId());
//        productRepository.save(product);
//
////        if test case success user generate id
//        Assertions.assertThat(product.getId()).isGreaterThan(0);
//    }
}
