package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDbService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order saveOrder(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteById(final Long id) {
        orderRepository.deleteById(id);
    }

    public Optional<Order> getOrder(final Long id) {
        return orderRepository.findById(id);
    }
}
