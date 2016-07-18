package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Type;

/**
 * ���������ͱ���в���
 * @author GJ
 *
 */
public interface TypeDao {

	/**
	 * ����id������������
	 * @param id
	 * @return Type
	 */
	public Type findTypeById(String id);
	
	/**
	 * ����������������
	 * @return List<Type>
	 */
	public List<Type> findAllType();
	
	/**
	 * �����������
	 * @param type
	 */
	public void addType(Type type);
	
	/**
	 * ɾ����������
	 * @param type
	 */
	public void deleteType(Type type);
	
	/**
	 * �޸���������
	 * @param type
	 */
	public void modifyType(Type type);
}
