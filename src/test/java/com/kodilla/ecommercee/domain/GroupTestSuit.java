package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.domains.Group;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupTestSuit {

    @Autowired
    private Group group;

    @Test
    public void updateName(){
        //Given
        Group group = new Group("name");

        //When
        group.setName("new_name");

        //Then
        Assert.assertEquals("new_name", group.getName());
    }
}
