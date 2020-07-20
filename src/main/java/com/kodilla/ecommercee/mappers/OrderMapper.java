package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Order;
import com.kodilla.ecommercee.domains.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserMapper userMapper;

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                productMapper.mapToProductList(orderDto.getProductDtos()),
                userMapper.mapToUser(orderDto.getUserDto()));
    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto(
                order.getId(),
                productMapper.mapToProductDtoList(order.getProducts()),
                userMapper.mapToUserDto(order.getUser()));

    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(t -> new OrderDto(
                        t.getId(),
                        productMapper.mapToProductDtoList(t.getProducts()),
                        userMapper.mapToUserDto(t.getUser())))
                .collect(Collectors.toList());
    }
}
