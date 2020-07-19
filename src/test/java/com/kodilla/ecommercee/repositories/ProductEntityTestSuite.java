package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.Optional;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    ProductRepository productRepository;

    @Test
    public void testSaveProduct() {
        //Given
        Group group = new Group("group");
        Product product = new Product("bike", new BigDecimal(100), 5 , group);
        //When
        productRepository.save(product);
        long id = product.getId();
        //Then
        Assert.assertEquals("bike", product.getName());
        Assert.assertEquals(new BigDecimal(100), product.getPrice());
        Assert.assertEquals(5, product.getQuantity(), 0.0001);
        Assert.assertEquals(group, product.getGroup());
    }
    @Test
    public void testReadProduct() {
        //Given
        Group group = new Group("group");
        Product product = new Product("bike", new BigDecimal(100), 5 , group);
        //When
        productRepository.save(product);
        long id = product.getId();
        //Then
        Assert.assertEquals("bike", product.getName());
        Assert.assertEquals(new BigDecimal(100), product.getPrice());
        Assert.assertEquals(5, product.getQuantity(), 0.0001);
        Assert.assertEquals(group, product.getGroup());
    }
    @Test
    public void testUpdateProduct() {
        //Given
        Group group = new Group("group");
        Product product = new Product("bike", new BigDecimal(100), 5 , group);
        Group updatedGroup = new Group("updatedGroup");
        //When
        productRepository.save(product);
        long id = product.getId();
        product.setName("car");
        product.setPrice(new BigDecimal(200));
        product.setQuantity(10);
        product.setGroup(updatedGroup);
        productRepository.save(product);
        //Then
        Assert.assertEquals("car", product.getName());
        Assert.assertEquals(new BigDecimal(200), product.getPrice());
        Assert.assertEquals(10, product.getQuantity(), 0.0001);
        Assert.assertEquals(updatedGroup, product.getGroup());
    }
    @Test
    public void testDeleteProduct() {
        //Given
        Group group = new Group("group");
        Product product = new Product("bike", new BigDecimal(100), 5 , group);
        //When
        productRepository.save(product);
        long id = product.getId();
        productRepository.delete(product);
        //Then
        Assert.assertEquals(Optional.empty(), productRepository.findById(id));
    }
}
