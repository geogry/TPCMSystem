package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.PassBorrow;

/**
 * 对通过的申领信息表的操作
 * @author GJ
 *
 */
public interface PassBorrowDao {

	/**
	 * 根据id查找已通过的借用信息
	 * @param id
	 * @return PassBorrow
	 */
	public PassBorrow findPassBorrowById(int id);
	
	/**
	 * 获取所有审核通过的借用信息
	 * @return List<PassBorrow>
	 */
	public List<PassBorrow> findAllPassBorrow();
	
	/**
	 * 查找对应用户审核通过的申领记录
	 * @param userId
	 * @return List
	 */
	public List<PassBorrow> findPassBorrowByUserId(String userId);
	
	/**
	 * 添加审核通过的借用信息
	 * @param passBorrow
	 */
	public void addPassBorrow(PassBorrow passBorrow);
	
	/**
	 * 修改已通过的申领信息
	 * @param passBorrow
	 */
	public void modifyPassBorrow(PassBorrow passBorrow);
	
	/**
	 * 删除已通过的借用信息
	 * @param passBorrow
	 */
	public void deletePassBorrow(PassBorrow passBorrow);
}
