package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.User;
import com.kodilla.ecommercee.domains.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    @Autowired
    private OrderMapper orderMapper;

    public User mapToUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                null); //orderMapper.mapToOrder(userDto.getOrderDto()));
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                null); //orderMapper.mapToOrderDto(user.getOrders()));
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(
                        t.getId(),
                        t.getName(),
                        null)) //orderMapper.mapToOrderDto(t.getOrders()))
                .collect(Collectors.toList());
    }
}
