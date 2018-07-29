package com.thoughtworks.library.controller;

import com.thoughtworks.library.model.LoginRequest;
import com.thoughtworks.library.model.User;
import com.thoughtworks.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static com.thoughtworks.library.constant.Constant.ERROR_MESSAGE.LOGIN_FAIL;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody LoginRequest request) {
        User matchedUser = userService.getAllUsers()
                .stream()
                .filter(user -> user.getUsername().equals(request.getUsername())
                        && user.getPassword().equals(request.getPassword()))
                .findFirst()
                .orElse(null);

        if (null == matchedUser) {
            return new ResponseEntity<>(LOGIN_FAIL, HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<>(matchedUser, HttpStatus.OK);
    }
}
