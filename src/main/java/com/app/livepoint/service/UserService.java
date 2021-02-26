package com.app.livepoint.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.livepoint.model.User;

public interface UserService {

	User save(User user);

	List<User> findAll();

	void delete(long id);
}