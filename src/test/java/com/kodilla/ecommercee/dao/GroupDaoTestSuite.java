package com.kodilla.ecommercee.dao;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class GroupDaoTestSuite {

    @Autowired
    private GroupDao groupDao;

    @Test
    public void testGroupDaoSave() {
        //Given
        Group group = new Group("testName");

        //When
        groupDao.save(group);

        //Then
        Long id = group.getId();
        Optional<Group> readGroup = groupDao.findById(id);
        String name = readGroup.get().getName();
        Assert.assertEquals("testName", name);
    }
    @Test
    public void testGroupDaoFindByName() {
        //Given
        Group group = new Group("testName");
        Group group2 = new Group("testName2");
        groupDao.save(group);
        groupDao.save(group2);
        String name = group.getName();

        //When
        List<Group> readGroups = groupDao.findByName(name);

        //Then
        Assert.assertEquals(1, readGroups.size());
        Assert.assertEquals("testName", readGroups.get(0).getName());
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
    }
    @Test
    public void testGroupDaoDelete() {
        //Given
        Group group = new Group("testName");

        //When
        groupDao.save(group);
        groupDao.delete(group);
        //Then
        Long k = groupDao.count();
        List<Group> readGroups = groupDao.findByName("testName");
        Assert.assertEquals(0, readGroups.size());
    }
    @Test
    public void testGroupDaoUpdate() {
        //Given
        Group group = new Group("testName");

        //When
        groupDao.save(group);
        group.setName("newTestName");
        groupDao.save(group);
        List<Group> readGroups = groupDao.findByName("newTestName");

        //Then
        Assert.assertEquals(1, readGroups.size());
        Assert.assertEquals("newTestName", readGroups.get(0).getName());
    }
}