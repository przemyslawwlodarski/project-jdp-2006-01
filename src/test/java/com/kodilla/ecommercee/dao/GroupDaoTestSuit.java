package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GroupDaoTestSuit {

    @Autowired
    private GroupDao groupDao;

    @Test
    public void testGroupDaoSave() {
        //Given
        Group group = new Group();

        //When
        groupDao.save(group);

        //Then
        Long id = group.getId();
        Optional<Group> readGroup = groupDao.findById(id);
        Assert.assertTrue(readGroup.isPresent());

        //CleanUp
        groupDao.deleteById(id);
    }
    @Test
    public void testGroupDaoFindByName() {
        //Given
        Group group = new Group("testName");
        groupDao.save(group);
        String name = group.getName();

        //When
        List<Group> readGroups = groupDao.findByName(name);

        //Then
        Assert.assertEquals(1, readGroups.size());

        //CleanUp
        Long id = group.getId();
        groupDao.deleteById(id);
    }
    @Test
    public void testGroupDaoSaveWithProductDetails() {
        //Given
        Group group = new Group();
        List<Product> productsList = new ArrayList<>();
        Product product = new Product();
        productsList.add(product);
        group.setProducts(productsList);

        //When
        groupDao.save(group);
        Long id = group.getId();

        //Then
        Assert.assertNotEquals(0, id, 0000.1);

        //CleanUp
        groupDao.deleteById(id);
    }
    @Test
    public void testGroupDaoDelete() {
        //Given
        Group group = new Group();

        //When
        groupDao.save(group);
        groupDao.delete(group);

        //Then
        Long k = groupDao.count();
        Assert.assertEquals(0, k, 0.001);
    }
}
