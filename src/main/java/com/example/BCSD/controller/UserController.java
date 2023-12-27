package com.example.BCSD.controller;

import com.example.BCSD.domain.User;
import com.example.BCSD.service.UserService;
import com.example.BCSD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @PostMapping("")
    public User insertUser(@RequestBody User user) throws SQLException {return userService.insertUser(user);}

    @GetMapping("")
    public List<User> getAllUsers() throws SQLException {return userService.getAllUsers();}

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable String userId) throws SQLException {return userService.getUserByUserId(userId);}

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId, @RequestBody User user) throws SQLException {userService.updateUserPw(userId, user);}

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) throws SQLException {userService.deleteUser(userId);}
}
