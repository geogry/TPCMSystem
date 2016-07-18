package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.TempBorrow;

/**
 * 对临时申领信息表进行操作
 * @author GJ
 *
 */
public interface TempBorrowDao {

	/**
	 * 根据id查找临时借用信息
	 * @param id
	 * @return TempBorrow
	 */
	public TempBorrow findTempBorrowById(int id);
	
	/**
	 * 查找所有临时借用信息
	 * @return List<TempBorrow>
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
