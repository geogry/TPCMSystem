package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.User;

/**
 * 对用户表进行增删改查
 * @author GJ
 *
 */
public interface UserDao {
	
	/**
	 * 用户登录查询
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
	 * @return List<User>
	 */
	public List<User> findAllUser();
	
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
	
	/**
	 * 修改用户
	 * @param user
	 */
	public void modifyUser(User user);
}
