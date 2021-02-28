package com.app.livepoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.livepoint.dao.User;
import com.app.livepoint.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User userSignUp(@RequestBody User user) {
        return userService.userSignUp(user);
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public User userSignIn(@RequestBody User user) {
        return userService.userSignIn(user);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @RequestMapping(value = "/all/{id}", method = RequestMethod.GET)
    public User findUserById(@PathVariable(value = "id") Long id) {
        return userService.findUserById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "success";
    }
}
