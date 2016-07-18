package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.RefuseBorrow;

/**
 * 对拒绝的申领信息表进行操作
 * @author GJ
 *
 */
public interface RefuseBorrowDao {

	/**
	 * 根据id查找拒绝的借用信息
	 * @param id
	 * @return RefuseBorrow
	 */
	public RefuseBorrow findRefuseBorrowById(int id);
	
	/**
	 * 查找所有的拒绝的借用信息
	 * @return List<RefuseBorrow>
	 */
	public List<RefuseBorrow> findAllRefuseBorrow();
	
	/**
	 * 查找对应用户的拒绝申请
	 * @param id
	 * @return List
	 */
	public List<RefuseBorrow> findRefuseBorrowByUserId(String userId);
	
	/**
	 * 添加拒绝的借用信息
	 * @param refuseBorrow
	 */
	public void addRefuseBorrow(RefuseBorrow refuseBorrow);
	
	/**
	 * 删除拒绝的借用信息
	 * @param refuseBorrow
	 */
	public void deleteRefuseBorrow(RefuseBorrow refuseBorrow);
}
