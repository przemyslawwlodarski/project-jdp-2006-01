package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository <Product, Long> {
    @Override
    List<Product> findAll();

    @Override
    Product save(Product product);

    @Override
    Optional<Product> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
