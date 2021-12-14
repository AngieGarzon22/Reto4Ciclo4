package com.usa.ciclo4.reto2ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "supplements")
public class Product {
    @Id
    private String reference;

    @Field(name= "brand")
    private String brand;

    @Field (name= "category")
    private String category;

    @Field (name= "objetivo")
    private String objetivo;

    @Field (name= "description")
    private String description;

    @Field (name= "availability")
    private boolean availability = true;

    @Field (name= "price")
    private double price;

    @Field (name= "quantity")
    private int quantity;

    @Field (name= "photography")
    private String photography;
}
