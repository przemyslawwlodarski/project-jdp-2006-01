package com.kodilla.ecommercee.domains;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity(name="products")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private double quantity;

    public Product() {
    }

    public Product(Long id, String name, BigDecimal price, double quantity ){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }
}