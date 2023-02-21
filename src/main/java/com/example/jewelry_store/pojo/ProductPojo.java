package com.example.jewelry_store.pojo;

import com.example.jewelry_store.entity.Product;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductPojo {
    private Integer id;

//    @NotEmpty(message = "Product field can't be empty")
    private String name;

//    @NotEmpty(message = "Category field can't be empty")
    private Integer categoryId;

//    @NotEmpty(message = "Price field can't be empty")
    private double price;

//    @NotEmpty(message = "Description field can't be empty")
    private String description;

    private String imageName;

    public ProductPojo(Product product) {
        this.id=product.getId();
        this.name= product.getName();
        this.categoryId=product.getCategory().getId();
        this.price=product.getPrice();
        this.description= product.getDescription();
        this.imageName= product.getImageName();
    }

//    public ProductPojo(Product product){
//        this.id=product.getId();
//        this.name= product.getName();
//        this.categoryId=product.getCategory().getId();
//        this.price=product.getPrice();
//        this.description=product.getDescription();
//    }

}
