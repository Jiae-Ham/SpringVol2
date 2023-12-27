package com.example.BCSD.service;

import com.example.BCSD.domain.User;
import com.example.BCSD.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceImpl{
    @Autowired
    UserMapper userMapper;

    public User insertUser(User user) {return userMapper.insertUser(user);}

    public List<User> getAllUsers() {return userMapper.getAllUsers();}

    public User getUserByUserId(String userId) {return userMapper.getUserByUserId(userId);}

    public void updateUserPw(String userId, User user) {userMapper.updateUserPw(userId, user);}

    public void deleteUser(String userId) {userMapper.deleteUser(userId);}

}
