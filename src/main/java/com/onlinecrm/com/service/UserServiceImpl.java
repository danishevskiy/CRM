package com.onlinecrm.com.service;

import com.onlinecrm.com.dao.UserDao;
import com.onlinecrm.com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public void deleteUserByName(String name) {
		dao.deleteUserByName(name);
	}

	public User findByName(String name) {
		return dao.findByName(name);
	}

	public void updateUser(User user){
		dao.updateUser(user);
	}
}
