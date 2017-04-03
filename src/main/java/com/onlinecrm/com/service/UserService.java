package com.onlinecrm.com.service;

import com.onlinecrm.com.model.User;

import java.util.List;

public interface UserService {

	void saveUser(User user);

	List<User> findAllUsers();

	void deleteUserBySsn(String ssn);

	User findBySsn(String ssn);

	void updateUser(User user);
}
