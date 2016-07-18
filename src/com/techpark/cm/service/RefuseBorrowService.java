package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.RefuseBorrow;

/**
 * 拒绝申领请求服务
 * @author GJ
 *
 */
public interface RefuseBorrowService {

	/**
	 * 根据id获得被拒绝的申领请求
	 * @param id
	 * @return RefuseBorrow
	 */
	public RefuseBorrow findRefuseBorrowById(int id);
	
	/**
	 * 获得所有被拒绝的申领请求
	 * @return List
	 */
	public List<RefuseBorrow> findAllRefuseBorrow();
	
	/**
	 * 查询对应用户被拒绝的申领请求
	 * @param userId
	 * @return List
	 */
	public List<RefuseBorrow> findRefuseBorrowByUserId(String userId);
	
	/**
	 * 添加拒绝申领请求
	 * @param refuseBorrow
	 */
	public void addRefuseBorrow(RefuseBorrow refuseBorrow);
	
	/**
	 * 删除拒绝申领请求
	 * @param refuseBorrow
	 */
	public void deleteRefuseBorrow(RefuseBorrow refuseBorrow);
}
