package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.TempPor;

/**
 * 为临时申购信息提供的服务
 * @author GJ
 *
 */
public interface TempPorService {

	/**
	 * 根据id查找临时申购信息
	 * @param id
	 * @return TempPor
	 */
	public TempPor findTempPorById(int id);
	
	/**
	 * 查找所有临时申购信息
	 * @return List
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
