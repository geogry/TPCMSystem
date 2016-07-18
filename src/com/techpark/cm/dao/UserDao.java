package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.User;

/**
 * ���û��������ɾ�Ĳ�
 * @author GJ
 *
 */
public interface UserDao {
	
	/**
	 * �û���¼��ѯ
	 * @param user
	 * @return List
	 */
	public List<User> login(User user);

	/**
	 * ����id�����û�
	 * @param id
	 * @return User
	 */
	public User findUserById(String id);
	
	/**
	 * �������еĹ���Ա
	 * @return List
	 */
	public List<User> findAllAdmin();
	
	/**
	 * ������ע����û�
	 * @return List
	 */
	public List<User> findRegisterUser();
	
	/**
	 * ���������û�
	 * @return List<User>
	 */
	public List<User> findAllUser();
	
	/**
	 * ����û�
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * ɾ���û�
	 * @param user
	 */
	public void deleteUser(User user);
	
	/**
	 * �޸��û�
	 * @param user
	 */
	public void modifyUser(User user);
}
