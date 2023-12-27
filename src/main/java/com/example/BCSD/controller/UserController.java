package com.example.BCSD.controller;

import com.example.BCSD.domain.User;
import com.example.BCSD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public User insertUser(@RequestBody User user) {return userService.insertUser(user);}

    @GetMapping("")
    public List<User> getAllUsers() {return userService.getAllUsers();}

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable String userId) {return userService.getUserByUserId(userId);}

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody User user) {userService.updateUserPw(userId, user);}

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {userService.deleteUser(userId);}
}
