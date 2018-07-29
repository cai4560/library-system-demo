package com.thoughtworks.library.service;

import com.thoughtworks.library.mapper.UserMapper;
import com.thoughtworks.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.listAll();
    }

    public User findUserById(Integer id) {
        return userMapper.findById(id);
    }

    public User findUserByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }

        return this.getAllUsers().stream()
                .filter(user ->  user.getToken().equals(token))
                .findFirst()
                .orElse(null);
    }
}
