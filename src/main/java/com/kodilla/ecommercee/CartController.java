package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.*;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestBody CartDto cartDto) {
        return new CartDto(1L, new UserDto(), new ArrayList<>());
    }
    @RequestMapping(method = RequestMethod.POST, value = "addProducts", consumes = APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestBody List<ProductDto> productDtos) {
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long productDtoId) {
    }
    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestParam Long cartDtoId) {
    }
}
