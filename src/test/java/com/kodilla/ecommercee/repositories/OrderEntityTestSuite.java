package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.domains.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderEntityTestSuite {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testSaveOrder() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 10, group2);
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        Order order = new Order(user1, products1);
        //When
        orderRepository.save(order);
        long id = order.getId();
        //Then
        Assert.assertEquals(products1, order.getProducts());
        Assert.assertEquals(user1, order.getUser());
    }

    @Test
    public void testReadOrder() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 10, group2);
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        Order order = new Order(user1, products1);
        //When
        orderRepository.save(order);
        long id = order.getId();
        //Then
        Assert.assertEquals(products1, order.getProducts());
        Assert.assertEquals(user1, order.getUser());
    }

    @Test
    public void testUpdateOrder() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 10, group2);
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        Order order = new Order(user1, products1);

        User user2 = new User("Mark");
        Product product3 = new Product("chair", new BigDecimal(50), 2, group1);
        Product product4 = new Product("pencil", new BigDecimal(3), 25, group2);
        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(product3);
        products2.add(product4);
        //When
        orderRepository.save(order);
        userRepository.save(user1);
        long id = order.getId();
        order.setUser(user2);
        order.setProducts(products2);
        userRepository.save(user2);
        orderRepository.save(order);
        //Then
        Assert.assertEquals(user2, order.getUser());
        Assert.assertEquals(products2, order.getProducts());
    }

    @Test
    public void testDeleteOrder() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 10, group2);
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        Order order = new Order(user1, products1);
        //When
        orderRepository.save(order);
        long id = order.getId();
        orderRepository.delete(order);
        //Then
        Assert.assertEquals(Optional.empty(), orderRepository.findById(id));
    }
}
