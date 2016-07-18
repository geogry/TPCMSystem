package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.User;

/**
 * 用户服务，用于对用户类进行操作
 * @author GJ
 *
 */
public interface UserService {
	
	/**
	 * 用于用户登录查询
	 * @param user
	 * @return List
	 */
	public List<User> login(User user);
	
	/**
	 * 按照id查找用户
	 * @param id
	 * @return User
	 */
	public User findUserById(String id);
	
	/**
	 * 查找所有的管理员
	 * @return List
	 */
	public List<User> findAllAdmin();
	
	/**
	 * 查找新注册的用户
	 * @return List
	 */
	public List<User> findRegisterUser();
	/**
	 * 查找所有用户
	 * @return List
	 */
	public List<User> findAllUser();
	
	/**
	 * 修改用户
	 * @param user
	 */
	public void modifyUser(User user);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 删除用户
	 * @param user
	 */
	public void deleteUser(User user);
}
