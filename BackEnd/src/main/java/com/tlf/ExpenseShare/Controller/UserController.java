package com.tlf.ExpenseShare.Controller;

import com.tlf.ExpenseShare.Model.User;
import com.tlf.ExpenseShare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<Optional<User>> getSpecificUsers(@PathVariable("user_id") int id) {
        return ResponseEntity.ok(userService.getSpecificUser(id));
    }
}

