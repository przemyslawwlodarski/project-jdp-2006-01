package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.User;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    @Override
    List<Order> findAll();

    @Override
    Order save(Order order);

    @Override
    Optional<Order> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();
}
