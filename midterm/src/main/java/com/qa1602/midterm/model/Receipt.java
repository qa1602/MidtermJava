package com.qa1602.midterm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
@Entity(name = "receipt")
@AllArgsConstructor
@NoArgsConstructor
public class Receipt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "receipt_products")
    @MapKeyJoinColumn(name = "receipt_id")
    @Column(name = "product_id")
    private Map<Long, Product> listProduct;

    private Double total;

    @ElementCollection
    @CollectionTable(joinColumns = @JoinColumn(name = "receiptid"))
    private List<Integer> amountP;

    private String username;

    private String phone;

    private String address;

    private String description;

}