package com.kodilla.ecommercee.repositories;

import com.kodilla.ecommercee.domains.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartEntityTestSuite {

    @Autowired
    CartRepository cartRepository;

    @Test
    public void testSaveCart() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 2, group2);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Cart cart = new Cart(user1, products);
        //When
        cartRepository.save(cart);
        long id = cart.getId();
        //Then
        Assert.assertEquals(user1, cart.getUser());
        Assert.assertEquals(products, cart.getProducts());
    }

    @Test
    public void testReadCart() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 2, group2);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Cart cart = new Cart(user1, products);
        //When
        cartRepository.save(cart);
        long id = cart.getId();
        //Then
        Assert.assertEquals(user1, cart.getUser());
        Assert.assertEquals(products, cart.getProducts());
    }

    @Test
    public void testUpdateCart() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 2, group2);
        ArrayList<Product> products1 = new ArrayList<>();
        products1.add(product1);
        products1.add(product2);
        Cart cart = new Cart(user1, products1);

        User user2 = new User("Mark");
        Product product3 = new Product("ball", new BigDecimal(5), 3, group1);
        Product product4 = new Product("table", new BigDecimal(10), 1, group2);
        ArrayList<Product> products2 = new ArrayList<>();
        products2.add(product3);
        products2.add(product4);
        //When
        cartRepository.save(cart);
        long id = cart.getId();
        System.out.println("Old user is: " + cart.getUser());
        cart.setUser(user2);
        cart.setProducts(products2);
        cartRepository.save(cart);
        System.out.println("New user is: " + cart.getUser());
        //Then
        Assert.assertEquals(user2, cart.getUser());
        Assert.assertEquals(products2, cart.getProducts());
    }

    @Test
    public void testDeleteCart() {
        //Given
        User user1 = new User("John");
        Group group1 = new Group("group1");
        Group group2 = new Group("group2");
        Product product1 = new Product("bike", new BigDecimal(100), 5, group1);
        Product product2 = new Product("computer", new BigDecimal(200), 2, group2);
        ArrayList<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        Cart cart = new Cart(user1, products);
        //When
        cartRepository.save(cart);
        long id = cart.getId();
        cartRepository.delete(cart);
        //Then
        Assert.assertEquals(Optional.empty(), cartRepository.findById(id));
    }

}
