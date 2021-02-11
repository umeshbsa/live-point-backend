package com.app.livepoint.service;

import com.app.livepoint.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {

    User save(User user);

    List<User> findAll();

    void delete(long id);
}