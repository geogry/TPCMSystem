package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.TempElement;

/**
 * 临时器件服务
 * @author GJ
 *
 */
public interface TempElementService {

	/**
	 * 根据id查找临时器件信息
	 * @param id
	 * @return TempElement
	 */
	public TempElement findTempElementById(int id);
	
	/**
	 * 获得所有临时器件信息
	 * @return TempElement
	 */
	public List<TempElement> findAllTempElement();
	
	/**
	 * 添加临时器件信息
	 * @param tempElement
	 */
	public void addTempElement(TempElement tempElement);
	
	/**
	 * 删除临时器件信息
	 * @param tempElement
	 */
	public void deleteTempElement(TempElement tempElement);
	
	/**
	 * 修改临时器件信息
	 * @param tempElement
	 */
	public void modifyTempElement(TempElement tempElement);
}
