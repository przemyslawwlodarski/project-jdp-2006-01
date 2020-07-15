package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Cart;
import com.kodilla.ecommercee.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CartRepository extends CrudRepository<Cart, Long> {
}
