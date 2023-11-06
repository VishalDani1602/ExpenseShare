package com.tlf.ExpenseShare.Service;

import com.tlf.ExpenseShare.Model.GroupParticipants;
import com.tlf.ExpenseShare.Repository.GroupParticipantRepository;
import com.tlf.ExpenseShare.Repository.UserRepository;
import com.tlf.ExpenseShare.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    private final GroupParticipantRepository groupParticipantRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, GroupParticipantRepository groupParticipantRepository) {
        this.userRepository = userRepository;
        this.groupParticipantRepository = groupParticipantRepository;
    }

    public User createUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    public int login(User user) {
        List<User> userlist = userRepository.findAll();
        for(User user1 : userlist){
            if(user.getEmail().equals(user1.getEmail()) && passwordEncoder.matches(user.getPassword(),user1.getPassword())){
                return user1.getUserId();
            }
        }
        return 0;
    }

    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> user.setPassword(null));
        return users;
    }
    public Optional<User> getSpecificUser(int id) {
        return userRepository.findById(id);
    }
    public List<GroupParticipants> getGroupParticipantsForGroup(int groupId) {
        // Use the groupParticipantRepository to retrieve group participants based on the group ID
        List<GroupParticipants> allParticipants = groupParticipantRepository.findAll();
        List<GroupParticipants> returnList = new ArrayList<>();
        for (GroupParticipants allParticipant : allParticipants) {
            if(allParticipant.getGroup().getGroupId() == groupId){
                returnList.add(allParticipant);
            }
        }
        return returnList;
    }
}
