package com.example.BCSD.repository;

import com.example.BCSD.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserMapper {

    static public ArrayList<User> users;

    static {
        users = new ArrayList<>();
        users.add(new User("abc1234", "test1", "1234"));
        users.add(new User("abc0000", "test2", "0000"));
        users.add(new User("abc3972", "test3", "3972"));
    }

    public User insertUser(User user) {
        users.add(user);
        return user;
    }

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserByUserId(String userId) {
        return users.stream()
                .filter(User -> User.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", ""));
    }

    public void updateUserPw(String userId, User user) {
        users.stream()
                .filter(User -> User.getUserId().equals(userId))
                .findAny()
                .orElse(new User("", "", ""))
                .setUserPw(user.getUserPw());
    }

    public void deleteUser(String userId) {
        users.removeIf(User -> User.getUserId().equals(userId));
    }
}
