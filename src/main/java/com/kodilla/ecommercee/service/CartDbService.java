package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domains.Cart;
import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.repositories.CartRepository;
import com.kodilla.ecommercee.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartDbService {
    @Autowired
    private CartRepository repository;

    public List<Cart> getAllCarts(){
        return repository.findAll();
    }

    public Cart saveCart(final Cart cart){
        return repository.save(cart);
    }

    public void deleteById(final Long id){
        repository.deleteById(id);
    }

    public Optional<Cart> getCart(final Long id) {
        return repository.findById(id);
    }
}
