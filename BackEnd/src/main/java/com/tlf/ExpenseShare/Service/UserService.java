package com.tlf.ExpenseShare.Service;

import com.tlf.ExpenseShare.Repository.UserRepository;
import com.tlf.ExpenseShare.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public int login(User user) {
        List<User> userlist = userRepository.findAll();
        for(User user1 : userlist){
            if(user.getEmail().equals(user1.getEmail()) && user.getPassword().equals(user1.getPassword())){
                return user1.getUserId();
            }
        }
        return 0;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public Optional<User> getSpecificUser(int id) {
        return userRepository.findById(id);
    }

}
