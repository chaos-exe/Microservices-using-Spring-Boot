package com.ankan.userservice.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ankan.userservice.service.UserService;
import com.ankan.userservice.entity.User;
import com.ankan.userservice.VO.ResponseTemplateVO;
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);

    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment (@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }



}
