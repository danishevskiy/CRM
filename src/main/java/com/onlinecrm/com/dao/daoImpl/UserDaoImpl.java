package com.onlinecrm.com.dao.daoImpl;

import com.onlinecrm.com.dao.AbstractDao;
import com.onlinecrm.com.dao.UserDao;
import com.onlinecrm.com.model.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao {

	public void saveUser(User user) {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public void deleteUserByName(String name) {
		Query query = getSession().createSQLQuery("delete from User where name = :name");
		query.setString("name", name);
		query.executeUpdate();
	}

	
	public User findByName(String name){
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("name", name));
		return (User) criteria.uniqueResult();
	}
	
	public void updateUser(User user){
		getSession().update(user);
	}
	
}
