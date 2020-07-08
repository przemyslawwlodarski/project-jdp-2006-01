package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Product;
import com.kodilla.ecommercee.domains.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private GroupMapper groupMapper;


    public Product mapToProduct(final ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQuantity(),
                orderMapper.maptToOrder(productDto.getOrderDto()),
                cartMapper.mapToCart(productDto.getCartDto()),
                groupMapper.mapToGroup(productDto.getGroupDto()));
    }

    public ProductDto mapToProductDto(final Product product){
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                orderMapper.mapToOrderDto(product.getOrders()),
                cartMapper.mapToProductDto(product.getCarts()),
                groupMapper.mapToGroupDto(product.getGroup()));
    }

    public List<ProductDto> mapToProductDtoList(final List<Product> productList){
        return productList.stream()
                .map(t -> new ProductDto(
                        t.getId(),
                        t.getName(),
                        t.getPrice(),
                        t.getQuantity(),
                        orderMapper.mapToOrderDto(t.getOrders()),
                        cartMapper.mapToProductDto(t.getCarts()),
                        roupMapper.mapToGroupDto(t.getGroup())))
                .collect(Collectors.toList());
    }
}
