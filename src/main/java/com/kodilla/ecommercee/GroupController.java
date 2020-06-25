package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.GroupDto;
import com.kodilla.ecommercee.domains.ProductDto;
import com.kodilla.ecommercee.errors.GroupNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/group")
public class GroupController {

    /*@Autowired
    private GroupDbService service;
    @Autowired
    private GroupMapper groupMapper;
    */

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return new ArrayList<>();
        //return groupMapper.mapToGroupDtoList(service.getAllGroups());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return new GroupDto(1L, "Group 1", new ArrayList<ProductDto>());
        //return groupMapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(GroupNotFoundException::new));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) {
        //service.deleteById(groupId);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return new GroupDto(1L,"Group 2", new ArrayList<ProductDto>());
        //return groupMapper.mapToGroupDto(service.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        //service.saveGroup(groupMapper.mapToGroup(groupDto));
    }
}