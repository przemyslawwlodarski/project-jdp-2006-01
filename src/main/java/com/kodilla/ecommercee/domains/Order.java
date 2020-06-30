package com.kodilla.ecommercee.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true)
    private Long id;

    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Product> products = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Order(Long id, List<Product> products, User user) {
        this.id = id;
        this.products = products;
        this.user = user;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Product> getProduct() {
        return products;
    }

    public void setProduct(List<Product> product) {
        this.products = products;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


