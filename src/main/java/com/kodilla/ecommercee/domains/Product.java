package com.kodilla.ecommercee.domains;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table (name="products")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "quantity")
    private double quantity;

    @ManyToOne
    @JoinColumn (name = "group_id")
    private Group group;

    public Product() {
    }

    public Product(String name, BigDecimal price, double quantity ){
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

    public Group getGroup() {
        return group;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
