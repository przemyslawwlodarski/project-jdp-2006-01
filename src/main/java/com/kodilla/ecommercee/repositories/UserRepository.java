package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByName(String name);
}
