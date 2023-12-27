package com.example.BCSD.service;

import com.example.BCSD.domain.User;
import com.example.BCSD.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User insertUser(User user) throws SQLException {
        return userMapper.insertUser(user);
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        return userMapper.getAllUsers();
    }

    @Override
    public User getUserByUserId(String userId) throws SQLException {
        return userMapper.getUserByUserId(userId);
    }

    @Override
    public void updateUserPw(String userId, User user) throws SQLException {
        userMapper.updateUserPw(userId, user);
    }

    @Override
    public void deleteUser(String userId) throws SQLException {
        userMapper.deleteUser(userId);
    }
}
