package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Locker;

/**
 * 对仓库表进行操作
 * @author GJ
 *
 */
public interface LockerDao {

	/**
	 * 按照id查找仓库
	 * @param id
	 * @return Locker
	 */
	public Locker findLockerById(String id);
	
	/**
	 * 查找所有的仓库
	 * @return List<Locker>
	 */
	public List<Locker> findAllLocker();
	
	/**
	 * 添加仓库
	 * @param locker
	 */
	public void addLocker(Locker locker);
	
	/**
	 * 删除仓库
	 * @param locker
	 */
	public void deleteLocker(Locker locker);
	
	/**
	 * 修改仓库
	 * @param locker
	 */
	public void modifyLocker(Locker locker);
}
