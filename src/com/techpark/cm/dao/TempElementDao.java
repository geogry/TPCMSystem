package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.TempElement;

/**
 * 对临时器件表进行操作
 * @author GJ
 *
 */
public interface TempElementDao {

	/**
	 * 根据id查找临时器件信息
	 * @param id
	 * @return TempElement
	 */
	public TempElement findTempElementById(int id);
	
	/**
	 * 查找所有临时器件信息
	 * @return List<TempElement>
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
