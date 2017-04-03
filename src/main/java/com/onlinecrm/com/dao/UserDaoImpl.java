package com.onlinecrm.com.dao;

import com.onlinecrm.com.model.User;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao implements UserDao{

	public void saveUser(User user) {
		persist(user);
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = getSession().createCriteria(User.class);
		return (List<User>) criteria.list();
	}

	public void deleteUserBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from User where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	
	public User findBySsn(String ssn){
		Criteria criteria = getSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("ssn", ssn));
		return (User) criteria.uniqueResult();
	}
	
	public void updateUser(User user){
		getSession().update(user);
	}
	
}
