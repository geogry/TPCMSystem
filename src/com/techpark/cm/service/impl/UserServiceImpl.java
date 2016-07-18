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
			throw new AppException("��ѯ�û���=��" + user.getUsername() + "�����û�ʧ��");
		}
	}
	
	@Override
	public User findUserById(String id) {
		try{
			return userDao.findUserById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "�����û�ʧ�ܣ�");
		}
	}

	@Override
	public List<User> findAllUser() {
		try{
			return userDao.findAllUser();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯ�����û�ʧ�ܣ�");
		}
	}
	
	@Override
	public List<User> findAllAdmin() {
		try{
			return userDao.findAllAdmin();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯ���Թ���Աʧ�ܣ�");
		}
	}

	@Override
	public void modifyUser(User user) {
		try{
			userDao.modifyUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("�޸�ID=��" + user.getId() + "�����û�ʧ�ܣ�");
		}
	}

	@Override
	public void addUser(User user) {
		try{
			userDao.addUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("����û�ʧ�ܣ�");
		}
	}

	@Override
	public void deleteUser(User user) {
		try{
			userDao.deleteUser(user);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + user.getId() + "�����û�ʧ�ܣ�");
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
			throw new AppException("������Ҫ��˵��û�ʧ�ܣ�");
		}
	}

}
