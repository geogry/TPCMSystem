package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.UserDao;
import com.techpark.cm.domain.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

	@Override
	public List<User> login(User user) {
		return getHibernateTemplate().find("from User user join fetch user.post left join fetch user.messages where user.username='" + 
													user.getUsername() + "' and user.password='" + user.getPassword() + "'");
	}
	
	@Override
	public User findUserById(String id) {
		return (User) getHibernateTemplate().find("from User user join fetch user.post where user.id='" + id + "'").get(0);
	}

	@Override
	public List<User> findAllUser() {
		return getHibernateTemplate().find("from User user join fetch user.post where user.post.id not in (0,1,2)");
	}
	
	@Override
	public List<User> findAllAdmin() {
		return getHibernateTemplate().find("from User user join fetch user.post where user.post.id = 2");
	}

	@Override
	public void addUser(User user) {
		getHibernateTemplate().save(user);
	}

	@Override
	public void deleteUser(User user) {
		getHibernateTemplate().delete(user);
	}

	@Override
	public void modifyUser(User user) {
		getHibernateTemplate().update(user);
	}

	@Override
	public List<User> findRegisterUser() {
		return getHibernateTemplate().find("from User user join fetch user.post where user.checked=0");
	}

}
