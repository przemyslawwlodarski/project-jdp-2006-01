package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

}
