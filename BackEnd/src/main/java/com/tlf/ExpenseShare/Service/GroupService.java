package com.tlf.ExpenseShare.Service;

import com.tlf.ExpenseShare.Model.Group;
import com.tlf.ExpenseShare.Model.GroupParticipants;
import com.tlf.ExpenseShare.Model.User;
import com.tlf.ExpenseShare.Repository.GroupParticipantRepository;
import com.tlf.ExpenseShare.Repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final GroupParticipantRepository groupParticipantRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository, GroupParticipantRepository groupParticipantRepository) {
        this.groupRepository = groupRepository;
        this.groupParticipantRepository = groupParticipantRepository;
    }

    public Group createGroup(@RequestBody Group group) {
//        return groupRepository.save(group);
        Group savedGroup = groupRepository.save(group);

        // Create a GroupParticipant entry for the creator
        GroupParticipants creatorParticipant = new GroupParticipants();
        creatorParticipant.setUser(group.getUser());
        creatorParticipant.setGroup(savedGroup);

        // Save the GroupParticipant entry
        groupParticipantRepository.save(creatorParticipant);

        return savedGroup;
    }

    public GroupParticipants addMember(@RequestBody GroupParticipants groupParticipants) {
        List<GroupParticipants> groupParticipantsList = groupParticipantRepository.findAll();
        boolean match = false;
        for (GroupParticipants participants : groupParticipantsList) {
            if(participants.getGroup().getGroupId() == groupParticipants.getGroup().getGroupId()
                    && participants.getUser().getUserId() == groupParticipants.getUser().getUserId() && !match){
                System.out.println("in match");
                match = true;
            }
        }
        if(match) {
            return groupParticipants;
        }else {
            return groupParticipantRepository.save(groupParticipants);
        }

    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public List<GroupParticipants> getAllGroupsParticipants() {
        return groupParticipantRepository.findAll();
    }

    public List<Group> getSpecificGroups(int id){
//        return groupRepository.findByCreatorId(id);
        List<Group> groupList = groupRepository.findAll();
        List<Group> filteredGroups = new ArrayList<>();

        for (Group group : groupList) {
            if (group.getUser().getUserId() == id) {
                filteredGroups.add(group);  // Add the group to the filtered list if the condition is met
            }
        }

        return filteredGroups;
    }


}
