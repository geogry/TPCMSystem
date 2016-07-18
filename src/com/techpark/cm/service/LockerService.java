package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Locker;

/**
 * �ֿ��������
 * @author GJ
 *
 */
public interface LockerService {

	/**
	 * ����id��ȡ�ֿ���Ϣ
	 * @param id
	 * @return Locker
	 */
	public Locker findLockerById(String id);
	
	/**
	 * ��ȡ���вֿ���Ϣ
	 * @return List
	 */
	public List<Locker> findAllLocker();
	
	/**
	 * ��Ӳֿ���Ϣ
	 * @param locker
	 */
	public void addLocker(Locker locker);
	
	/**
	 * ɾ���ֿ���Ϣ
	 * @param locker
	 */
	public void deleteLocker(Locker locker);
	
	/**
	 * �޸Ĳֿ���Ϣ
	 * @param locker
	 */
	public void modifyLocker(Locker locker);
}
