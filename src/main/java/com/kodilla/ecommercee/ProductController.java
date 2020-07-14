package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.GroupDto;
import com.kodilla.ecommercee.domains.ProductDto;
import com.kodilla.ecommercee.errors.GroupNotFoundException;
import com.kodilla.ecommercee.errors.ProductNotFoundException;
import com.kodilla.ecommercee.mappers.ProductMapper;
import com.kodilla.ecommercee.service.ProductDbService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductDbService service;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(service.getAllProducts());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(@RequestParam Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(service.getProduct(productId).orElseThrow(() -> new ProductNotFoundException("Product not found " + productId)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        service.saveProduct(productMapper.mapToProduct(productDto));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return productMapper.mapToProductDto(service.saveProduct(productMapper.mapToProduct(productDto)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestParam Long productId) {
        try {
            service.deleteById(productId);
        } catch (EmptyResultDataAccessException e) {
            throw new ProductNotFoundException("Product not found " + productId, e);
        }
    }
}