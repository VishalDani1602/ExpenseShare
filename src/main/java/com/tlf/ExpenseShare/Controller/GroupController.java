package com.tlf.ExpenseShare.Controller;

import com.tlf.ExpenseShare.Model.Group;
import com.tlf.ExpenseShare.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/")
    public Group createGroup(Group group) {
        return groupService.createGroup(group);
    }

    @GetMapping("/")
    public List<Group> getAllGroups() {
        return groupService.getAllGroups();
    }
}

