package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.UserDto;
import com.kodilla.ecommercee.errors.UserNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    /*@
    Autowired
    private UserDbService service;
    @Autowired
    private UserMapper groupMapper;
    */

    @RequestMapping(method = RequestMethod.GET, value = "getUsers")
    public List<UserDto> getGroups() {
        return new ArrayList<>();
        //return userMapper.mapToUserDtoList(service.getAllUsers());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getUser")
    public UserDto getUser(@RequestParam Long userId) throws UserNotFoundException {
        return new UserDto(1L, "User 1");
        //return userMapper.mapToUserDto(service.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUser")
    public void deleteUser(@RequestParam Long userId) {
        //service.deleteById(userId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto(1L,"User 2");
        //return userMapper.mapToUserDto(service.saveUser(userMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUser", consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        //service.saveUser(userMapper.mapToUser(userDto));
    }
}
