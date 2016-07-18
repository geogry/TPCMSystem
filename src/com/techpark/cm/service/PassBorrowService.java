package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.PassBorrow;

/**
 * 审核通过的申领信息服务
 * @author GJ
 *
 */
public interface PassBorrowService {

	/**
	 * 根据id获取通过审核的申领信息
	 * @param id
	 * @return PassBorrow
	 */
	public PassBorrow findPassBorrowById(int id);
	
	/**
	 * 获取所有审核通过的申领信息
	 * @return List
	 */
	public List<PassBorrow> findAllPassBorrow();
	
	/**
	 * 查找对应用户的已通过申领
	 * @param userId
	 * @return List
	 */
	public List<PassBorrow> findPassBorrowByUserId(String userId);
	
	/**
	 * 添加审核通过的申领信息
	 * @param passBorrow
	 */
	public void addPassBorrow(PassBorrow passBorrow);
	
	/**
	 * 修改已通过申领信息
	 * @param passBorrow
	 */
	public void modifyPassBorrow(PassBorrow passBorrow);
	
	/**
	 * 删除审核通过的申领信息
	 * @param passBorrow
	 */
	public void deletePassBorrow(PassBorrow passBorrow);
}
