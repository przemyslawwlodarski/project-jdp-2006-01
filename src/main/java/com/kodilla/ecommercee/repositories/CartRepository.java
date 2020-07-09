package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {
}
