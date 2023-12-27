package com.example.BCSD.service;

import com.example.BCSD.domain.User;

import java.util.List;

public interface UserServiceImpl {
    public User insertUser(User user);

    public List<User> getAllUsers();

    public User getUserByUserId(String userId);

    public void updateUserPw(String userId, User user);

    public void deleteUser(String userId);
}
