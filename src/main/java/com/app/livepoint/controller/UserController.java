package com.app.livepoint.controller;

import com.app.livepoint.model.User;
import com.app.livepoint.service.UserService;
import com.app.livepoint.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List listUser() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Long id) {
        userService.delete(id);
        return "success";
    }

}