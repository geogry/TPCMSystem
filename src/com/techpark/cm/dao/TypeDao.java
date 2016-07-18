package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Type;

/**
 * 对器件类型表进行操作
 * @author GJ
 *
 */
public interface TypeDao {

	/**
	 * 按照id查找器件类型
	 * @param id
	 * @return Type
	 */
	public Type findTypeById(String id);
	
	/**
	 * 查找所有器件类型
	 * @return List<Type>
	 */
	public List<Type> findAllType();
	
	/**
	 * 添加器件类型
	 * @param type
	 */
	public void addType(Type type);
	
	/**
	 * 删除器件类型
	 * @param type
	 */
	public void deleteType(Type type);
	
	/**
	 * 修改器件类型
	 * @param type
	 */
	public void modifyType(Type type);
}
