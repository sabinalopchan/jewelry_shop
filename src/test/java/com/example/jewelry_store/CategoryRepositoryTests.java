package com.example.jewelry_store;//package com.example.liquor_store;
import com.example.jewelry_store.entity.Category;
import com.example.jewelry_store.entity.Product;
import com.example.jewelry_store.repository.CategoryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void saveCategoryTest(){
        Category category=Category.builder()
                .name("Ring")
                .build();
        categoryRepository.save(category);

        Assertions.assertThat(category.getId()).isGreaterThan(0);
    }
    @Test
    public void updateUCategoryTest(){

        Category category=Category.builder()
                .name("Ring")
                .build();
        categoryRepository.save(category);

        Category category1 = categoryRepository.findById(category.getId()).get();
        category1.setName("Earring");
        categoryRepository.save(category1);

        Assertions.assertThat(category1.getId()).isEqualTo(1);
    }

    @Test
    public void DeleteCategoryTest(){

        Category category=Category.builder()
                .name("Ring")
                .build();
        categoryRepository.save(category);

        Category category1 = categoryRepository.findById(category.getId()).get();
        categoryRepository.delete(category1);

        Optional<Category> deletedUser = categoryRepository.findById(category1.getId());

        Assertions.assertThat(deletedUser.isPresent()).isEqualTo(false);
    }

}

