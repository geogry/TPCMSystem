package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.TempPor;

/**
 * 对临时申购信息表进行操作
 * @author GJ
 *
 */
public interface TempPorDao {

	/**
	 * 根据id查找临时申购信息
	 * @param id
	 * @return TempPor
	 */
	public TempPor findTempPorById(int id);
	
	/**
	 * 查找所有临时申购信息
	 * @return List<TempPor>
	 */
	public List<TempPor> findAllTempPor();
	
	/**
	 * 添加临时申购信息
	 * @param tempPor
	 */
	public void addTempPor(TempPor tempPor);
	
	/**
	 * 删除临时申购信息
	 * @param tempPor
	 */
	public void deleteTempPor(TempPor tempPor);
	
	/**
	 * 修改临时申购信息
	 * @param tempPor
	 */
	public void modifyTempPor(TempPor tempPor);
}
