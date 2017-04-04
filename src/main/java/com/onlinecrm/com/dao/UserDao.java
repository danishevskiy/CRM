package com.onlinecrm.com.dao;

import com.onlinecrm.com.model.User;

import java.util.List;

public interface UserDao {

	void saveUser(User user);
	
	List<User> findAllUsers();
	
	void deleteUserByName(String user);
	
	User findByName(String user);
	
	void updateUser(User user);
}
