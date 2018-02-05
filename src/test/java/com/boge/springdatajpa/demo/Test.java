package com.boge.springdatajpa.demo;

import com.boge.springdatajpa.demo.model.entity.User;
import com.boge.springdatajpa.demo.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Resource
    UserService userService;

    @org.junit.Test
    public void getUser() {
        System.out.println(userService.getUser(1));
    }

    @org.junit.Test
    public void getUsersForPage() {
        System.out.println(userService.getUsersForPage(1, 1));
    }

    @org.junit.Test
    public void getUsersForPageByConditions() {
        User user = new User();
        user.setName("张三");
        System.out.println(userService.getUsersForPageByConditions(1, 2, user).getContent());
    }

    @org.junit.Test
    public void getUsersByName() {
        System.out.println(userService.getUsersByName("张"));
    }

    @org.junit.Test
    public void getUsersById() {
        System.out.println(userService.getUsersById(3));
    }

    @org.junit.Test
    public void getUsersByPassword() {
        System.out.println(userService.getUsersByPassword("11"));
    }

    @org.junit.Test
    public void getUsersByUserName() {
        System.out.println(userService.getUsersByUserName("12"));
    }

    @org.junit.Test
    public void getUsersByPassword2() {
        System.out.println(userService.getUsersByPassword2("11"));
    }

    @org.junit.Test
    public void updateUser() {
        System.out.println(userService.updateUser(4, "11211"));
    }

    @org.junit.Test
    public void getUserByNameAndTel() {
        System.out.println(userService.getUserByNameAndTel("张三物", "11"));
    }

    @org.junit.Test
    public void test() {
        Assert.hasText("", "null");
    }

}