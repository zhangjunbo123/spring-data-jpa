package com.boge.springdatajpa.demo.controller;

import com.boge.springdatajpa.demo.model.entity.User;
import com.boge.springdatajpa.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/getusers.json")
    public Page<User> getUsersForPage() {
        Page<User> userPage = userService.getUsersForPage(1, 2);
        return userPage;
    }

}
