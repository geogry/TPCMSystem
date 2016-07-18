package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Type;

/**
 * �������͵ķ���
 * @author GJ
 *
 */
public interface TypeService {
	
	/**
	 * ����id������������
	 * @param id
	 * @return Type
	 */
	public Type findTypeById(String id);
	
	/**
	 * ����������������
	 * @return List
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
