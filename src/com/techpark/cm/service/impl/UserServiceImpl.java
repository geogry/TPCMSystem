package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.UserDao;
import com.techpark.cm.domain.User;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	@Override
	public List<User> login(User user) {
		try{
			return userDao.login(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询用户名=【" + user.getUsername() + "】的用户失败");
		}
	}
	
	@Override
	public User findUserById(String id) {
		try{
			return userDao.findUserById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询ID=【" + id + "】的用户失败！");
		}
	}

	@Override
	public List<User> findAllUser() {
		try{
			return userDao.findAllUser();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询所以用户失败！");
		}
	}
	
	@Override
	public List<User> findAllAdmin() {
		try{
			return userDao.findAllAdmin();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询所以管理员失败！");
		}
	}

	@Override
	public void modifyUser(User user) {
		try{
			userDao.modifyUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("修改ID=【" + user.getId() + "】的用户失败！");
		}
	}

	@Override
	public void addUser(User user) {
		try{
			userDao.addUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("添加用户失败！");
		}
	}

	@Override
	public void deleteUser(User user) {
		try{
			userDao.deleteUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("删除ID=【" + user.getId() + "】的用户失败！");
		}
	}

	public void setUserDao(UserDao userDao) {
			this.userDao = userDao;
	}

	@Override
	public List<User> findRegisterUser() {
		try {
			return userDao.findRegisterUser();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查找需要审核的用户失败！");
		}
	}

}
