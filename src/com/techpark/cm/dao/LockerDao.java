package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Locker;

/**
 * �Բֿ����в���
 * @author GJ
 *
 */
public interface LockerDao {

	/**
	 * ����id���Ҳֿ�
	 * @param id
	 * @return Locker
	 */
	public Locker findLockerById(String id);
	
	/**
	 * �������еĲֿ�
	 * @return List<Locker>
	 */
	public List<Locker> findAllLocker();
	
	/**
	 * ��Ӳֿ�
	 * @param locker
	 */
	public void addLocker(Locker locker);
	
	/**
	 * ɾ���ֿ�
	 * @param locker
	 */
	public void deleteLocker(Locker locker);
	
	/**
	 * �޸Ĳֿ�
	 * @param locker
	 */
	public void modifyLocker(Locker locker);
}
