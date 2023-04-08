package com.qa1602.midterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Entity(name = "cart")
@AllArgsConstructor
@NoArgsConstructor
public class Cart implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "cartid"))
    private List<Product> listProduct;

    private Double total;
    
    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "cartid"))
    private List<Integer> amountP;
}