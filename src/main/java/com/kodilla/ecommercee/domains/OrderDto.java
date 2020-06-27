package com.kodilla.ecommercee.domains;

import java.util.List;

public class OrderDto {
    private Long id;
    private List<ProductDto> products;
    private UserDto userDto;

    public OrderDto(Long id, List<ProductDto> products, UserDto userDto) {
        this.id = id;
        this.products = products;
        this.userDto = userDto;
    }

    public Long getId() {
        return id;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public UserDto getUserDto() {
        return userDto;
    }
}



