package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends CrudRepository<Group, Long> {
    @Override
    List<Group> findAll();

    @Override
    Group save(Group group);

    @Override
    Optional<Group> findById(Long id);

    @Override
    void deleteById(Long id);

    @Override
    long count();

    List<Group> findByName(String name);
}
