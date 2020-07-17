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

    private List<Product> currentProducts = new ArrayList<>();


    @RequestMapping(method = RequestMethod.POST, value = "createCart", consumes = APPLICATION_JSON_VALUE)
    public void createCart(@RequestBody CartDto cartDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCarts")
    public List<CartDto> getCarts() {
        return cartMapper.mapToCartDtoList(service.getAllCarts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public CartDto getCart(@RequestParam Long cartId) throws CartNotFoundException {
        return cartMapper.mapToCartDto(service.getCart(cartId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartId)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCart")
    public List<Product> getProductFromCart(@RequestParam Long cartDtoId) throws CartNotFoundException {
        List<Product> currentProducts = service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId)).getProducts();
        return currentProducts;
    }

    @RequestMapping(method = RequestMethod.POST, value = "addProducts", consumes = APPLICATION_JSON_VALUE)
    public void addProductsToCart(@RequestBody Long cartDtoId, List<ProductDto> products) throws CartNotFoundException {
        getProductFromCart(cartDtoId);
        for (int i=0; i<products.size(); i++){
            currentProducts.add(productMapper.mapToProduct(products.get(i)));
        }
        service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId)).setProducts(currentProducts);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
    public void deleteProductFromCart(@RequestParam Long cartDtoId, Long productDtoId) throws CartNotFoundException{
        getProductFromCart(cartDtoId);
        currentProducts.remove(productService.getProduct(productDtoId));
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
    public Order createOrder(@RequestParam Long cartDtoId) throws CartNotFoundException {
        return new Order(
                getCart(cartDtoId).getId(),
                productMapper.mapToProductList(cartMapper.mapToCartDto(service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId))).getProducts()),
                userMapper.mapToUser(cartMapper.mapToCartDto(service.getCart(cartDtoId).orElseThrow(()-> new CartNotFoundException("Cart not found "+ cartDtoId))).getUserDto()));
    }
}
