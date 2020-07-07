package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.errors.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserEntityTestSuite {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveUser() {
        //Given
        User user = new User("John");
        //When
        userRepository.save(user);
        long id = user.getId();
        //Then
        Assert.assertEquals("John", user.getName());
    }

    @Test
    public void testReadUser() {
        //Given
        User user = new User("John");
        //When
        userRepository.save(user);
        long id = user.getId();
        //Then
        Assert.assertEquals("John", user.getName());
    }

    @Test
    public void testUpdateUser() {
        //Given
        User user = new User("John");
        //When
        userRepository.save(user);
        long id = user.getId();
        user.setName("Mark");
        userRepository.save(user);
        //Then
        Assert.assertEquals("Mark", user.getName());
    }

    @Test
    public void testDeleteUser() {
        //Given
        User user = new User("John");
        //When
        userRepository.save(user);
        userRepository.delete(user);
        //Then
        Assert.assertEquals(0, userRepository.count());
    }
}
