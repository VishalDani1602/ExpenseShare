package com.tlf.ExpenseShare.Service;

import com.tlf.ExpenseShare.Model.Group;
import com.tlf.ExpenseShare.Model.User;
import com.tlf.ExpenseShare.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group createGroup(@RequestBody Group group) {
        return groupRepository.save(group);
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public List<Group> getSpecificGroups(int id){
        return groupRepository.findByCreatorId(id);
    }


}
