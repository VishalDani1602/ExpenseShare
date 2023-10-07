package com.tlf.ExpenseShare.Controller;

import com.tlf.ExpenseShare.Model.User;
import com.tlf.ExpenseShare.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin
public class LoginController {
    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Integer> login(@RequestBody User user){
        return ResponseEntity.ok(userService.login(user));
    }
}
