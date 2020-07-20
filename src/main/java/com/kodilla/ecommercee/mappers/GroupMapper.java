package com.kodilla.ecommercee.mappers;

import com.kodilla.ecommercee.domains.Group;
import com.kodilla.ecommercee.domains.GroupDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper {

    /*
    Autowired
    private ProductMapper productMapper
    */

    public Group mapToGroup(final GroupDto groupDto){
        return new Group(
                groupDto.getId(),
                groupDto.getName(),
                null); //productMapper.mapToProduct(groupDto.getProductDtoList());
    }

    public GroupDto mapToGroupDto(final Group group){
        return new GroupDto(
                group.getId(),
                group.getName(),
                null); //productMapper.mapToProductDto(group.getProducts));
    }

    public List<GroupDto> mapToGroupDtoList(final List<Group> groupList){
        return groupList.stream()
                .map(t -> new GroupDto(
                        t.getId(),
                        t.getName(),
                        null)) //productMapper.mapToProductDto(t.getProduct())))
                .collect(Collectors.toList());
    }
}
