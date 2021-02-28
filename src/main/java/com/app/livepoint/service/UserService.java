package com.app.livepoint.service;

import java.util.List;

import com.app.livepoint.dao.User;

public interface UserService {

    User userSignUp(User user);

    User userSignIn(User user);

    List<User> findAllUser();

    User findUserById(long userId);

    void delete(long id);
}