package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Cart;
import com.kodilla.ecommercee.domains.CartDto;
import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.GroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapper {


    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    public Cart mapToCart(final CartDto cartDto){
        return new Cart(
                cartDto.getId(),
                userMapper.mapToUser(cartDto.getUserDto()),
                productMapper.mapToProductList(cartDto.getProducts()));
    }

    public CartDto mapToCartDto(final Cart cart){
        return new CartDto(
                cart.getId(),
                userMapper.mapToUserDto(cart.getUser()),
                productMapper.mapToProductDtoList(cart.getProducts()));
    }

    public List<CartDto> mapToCartDtoList(final List<Cart> cartList){
        return cartList.stream()
                .map(t -> new CartDto(
                        t.getId(),
                        userMapper.mapToUserDto(t.getUser()),
                        productMapper.mapToProductDtoList(t.getProducts())))
                .collect(Collectors.toList());
    }
}
