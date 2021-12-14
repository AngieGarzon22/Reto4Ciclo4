package com.usa.ciclo4.reto2ciclo4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.Map;

@Document(collection = "orders")

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";

    @Id
    private Integer id;

    @Field (name= "registerDay")
    private Date registerDay;

    @Field (name= "status")
    private String status;

    @Field (name= "salesMan")
    private User salesMan;

    @Field (name= "products")
    private Map<String, Product> products;

    @Field (name= "quantities")
    private Map<String, Integer> quantities;
}
