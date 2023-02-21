package com.example.jewelry_store.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //create table
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;

//    Since 1 category has many product
//    The FetchType. LAZY tells Hibernate to only fetch the related entities from the database when you use the relationship.
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id") //To join table
    private Category category; //Pass Object
    private double price;
    private String description;
    private String imageName;

//    @Transient
//    private String imageBase64;

}
