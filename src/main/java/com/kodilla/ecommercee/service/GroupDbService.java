package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupDbService {

    @Autowired
    private GroupRepository repository;

    public List<Group> getAllGroups(){
        return repository.findAll();
    }

    public Group saveGroup(final Group group){
        return repository.save(group);
    }

    public void deleteById(final Long id){
        repository.deleteById(id);
    }

    public Optional<Group> getGroup(final Long id) {
        return repository.findById(id);
    }
}
