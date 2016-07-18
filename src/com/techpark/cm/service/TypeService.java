package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Type;

/**
 * 器件类型的服务
 * @author GJ
 *
 */
public interface TypeService {
	
	/**
	 * 按照id查找器件类型
	 * @param id
	 * @return Type
	 */
	public Type findTypeById(String id);
	
	/**
	 * 查找所有器件类型
	 * @return List
	 */
	public List<Type> findAllType();
	
	/**
	 * 添加器件类型
	 * @param type
	 */
	public void addType(Type type);
	
	/**
	 * 删除掐紧类型
	 * @param type
	 */
	public void deleteType(Type type);
	
	/**
	 * 修改器件类型
	 * @param type
	 */
	public void modifyType(Type type);
}
