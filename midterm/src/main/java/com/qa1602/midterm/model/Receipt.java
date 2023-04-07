package com.qa1602.midterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "receipt")
@AllArgsConstructor
@NoArgsConstructor
public class Receipt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private List<Product> listProduct;

    private Double total;

    private List<Integer> amountP;

    private String username;

    private int phone;

    private String address;

    private String description;
}