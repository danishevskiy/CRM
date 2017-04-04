package com.onlinecrm.com.service;

import com.onlinecrm.com.model.User;

import java.util.List;

public interface UserService {

	void saveUser(User user);

	List<User> findAllUsers();

	void deleteUserByName(String name);

	User findByName(String name);

	void updateUser(User user);
}
