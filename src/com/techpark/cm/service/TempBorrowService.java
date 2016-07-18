package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.TempBorrow;

/**
 * 临时借用服务
 * @author GJ
 *
 */
public interface TempBorrowService {

	/**
	 * 根据id获得临时借用信息
	 * @param id
	 * @return TempBorrow
	 */
	public TempBorrow findTempBorrowById(int id);
	
	/**
	 * 获得所有临时借用信息
	 * @return List
	 */
	public List<TempBorrow> findAllTempBorrow();
	
	/**
	 * 添加临时借用信息
	 * @param tempBorrow
	 */
	public void addTempBorrow(TempBorrow tempBorrow);
	
	/**
	 * 删除临时借用信息
	 * @param tempBorrow
	 */
	public void deleteTempBorrow(TempBorrow tempBorrow);
}
