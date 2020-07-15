package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domains.GroupDto;
import com.kodilla.ecommercee.domains.ProductDto;
import com.kodilla.ecommercee.errors.GroupNotFoundException;
import com.kodilla.ecommercee.mappers.GroupMapper;
import com.kodilla.ecommercee.service.GroupDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @Autowired
    private GroupDbService service;
    @Autowired
    private GroupMapper groupMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getGroups")
    public List<GroupDto> getGroups() {
        return groupMapper.mapToGroupDtoList(service.getAllGroups());
    }
    @RequestMapping(method = RequestMethod.GET, value = "getGroup")
    public GroupDto getGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(service.getGroup(groupId).orElseThrow(() -> new GroupNotFoundException("Group not found " + groupId)));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteGroup")
    public void deleteGroup(@RequestParam Long groupId) throws GroupNotFoundException {
        try {
            service.deleteById(groupId);;
        } catch (EmptyResultDataAccessException e) {
            throw new GroupNotFoundException("Group not found " + groupId, e);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateGroup")
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(service.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "createGroup", consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupMapper.mapToGroup(groupDto));
    }
}