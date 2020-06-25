package com.kodilla.ecommercee.domains;

import java.util.List;

public class GroupDto {
    private Long id;
    private String name;
    private List<ProductDto> productDtoList;

    public GroupDto(Long id, String name, List<ProductDto> productDtoList) {
        this.id = id;
        this.name = name;
        this.productDtoList = productDtoList;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProductDto> getProductDtoList() {
        return productDtoList;
    }
}
