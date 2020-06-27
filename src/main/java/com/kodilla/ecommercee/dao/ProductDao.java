package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domains.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<Product, Integer> {
}
