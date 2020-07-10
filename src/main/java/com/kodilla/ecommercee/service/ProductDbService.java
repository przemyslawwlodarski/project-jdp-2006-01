package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDbService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    public Product saveProduct(final Product product){
        return repository.save(product);
    }

    public void deleteById(final Long id){
        repository.deleteById(id);
    }

    public Optional<Product> getProduct(final Long id){
        return repository.findById(id);
    }


}
