package com.tlf.ExpenseShare.Controller;

import com.tlf.ExpenseShare.Model.Group;
import com.tlf.ExpenseShare.Model.GroupParticipants;
import com.tlf.ExpenseShare.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
@CrossOrigin
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping("/create")
    public Group createGroup(@RequestBody Group group) {
        return groupService.createGroup(group);
    }

    @PostMapping("/add")
    public GroupParticipants addMember(@RequestBody GroupParticipants groupParticipants) {
        return groupService.addMember(groupParticipants);
    }

    @GetMapping("/")
    public ResponseEntity<List<Group>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAllGroups());
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<List<Group>> getSpecificUsers(@PathVariable("user_id") int id) {
        return ResponseEntity.ok(groupService.getSpecificGroups(id));
    }


}

