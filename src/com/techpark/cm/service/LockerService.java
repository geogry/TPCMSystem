package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Locker;

/**
 * 仓库操作服务
 * @author GJ
 *
 */
public interface LockerService {

	/**
	 * 根据id获取仓库信息
	 * @param id
	 * @return Locker
	 */
	public Locker findLockerById(String id);
	
	/**
	 * 获取所有仓库信息
	 * @return List
	 */
	public List<Locker> findAllLocker();
	
	/**
	 * 添加仓库信息
	 * @param locker
	 */
	public void addLocker(Locker locker);
	
	/**
	 * 删除仓库信息
	 * @param locker
	 */
	public void deleteLocker(Locker locker);
	
	/**
	 * 修改仓库信息
	 * @param locker
	 */
	public void modifyLocker(Locker locker);
}
