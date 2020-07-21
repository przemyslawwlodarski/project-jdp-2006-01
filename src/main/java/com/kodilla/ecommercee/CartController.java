package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.*;
import com.kodilla.ecommercee.errors.CartNotFoundException;
import com.kodilla.ecommercee.errors.ProductNotFoundException;
import com.kodilla.ecommercee.mappers.CartMapper;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.mappers.UserMapper;
import com.kodilla.ecommercee.service.CartDbService;
import com.kodilla.ecommercee.service.ProductDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/cart")
public class CartController {

    @Autowired
    private CartDbService service;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductDbService productService;
    @Autowired
    private UserMapper userMapper;
    /*
    Autowired
    private OrderDBService orderService
     */

    private List<Product> currentProducts = new ArrayList<>();


    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
        service.saveCart(cartMapper.mapToCart(cartDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(service.getAllCarts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) throws CartNotFoundException {
        return cartMapper.mapToCartDto(service.getCart(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartId)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProducts", consumes = APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestParam Long cartDtoId, @RequestBody List<ProductDto> products) throws CartNotFoundException {
        Cart cart = service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId));
        cart.getProducts().addAll(productMapper.mapToProductList(products));
        service.saveCart(cart);
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProduct", consumes = APPLICATION_JSON_VALUE)
    public void addProductToCart(@RequestParam Long cartDtoId, @RequestBody ProductDto productDto) throws CartNotFoundException, ProductNotFoundException {
        addProductsToCart(cartDtoId, Collections.singletonList(productDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProductFromCart(@RequestParam Long cartDtoId, @RequestBody ProductDto productDto) throws CartNotFoundException, ProductNotFoundException{
        deleteProductsFromCart(cartDtoId, Collections.singletonList(productDto));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProducts")
    public void deleteProductsFromCart(@RequestParam Long cartDtoId, @RequestBody List<ProductDto> products) throws CartNotFoundException{
        Cart cart = service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId));
        cart.getProducts().removeAll(productMapper.mapToProductList(products));
        service.saveCart(cart);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCart")
    public void deleteCart(@RequestParam Long cartId) {
        try{
            service.deleteById(cartId);
        } catch (EmptyResultDataAccessException e){
            throw new ProductNotFoundException("Cart not found " + cartId, e);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public void createOrder(@RequestParam Long cartDtoId) throws CartNotFoundException {
        /*orderService.saveOrder(new Order(
                getCart(cartDtoId).getId(),
                productMapper.mapToProductList(cartMapper.mapToCartDto(service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId))).getProducts()),
                userMapper.mapToUser(cartMapper.mapToCartDto(service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId))).getUserDto())));
         */
    }
}
