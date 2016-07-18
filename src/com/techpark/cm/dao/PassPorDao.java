package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.PassPor;

/**
 * 对已通过的申购信息表进行操作
 * @author GJ
 *
 */
public interface PassPorDao {

	/**
	 * 根据id查找已通过审核的申购信息
	 * @param id
	 * @return PassPor
	 */
	public PassPor findPassPorById(int id);
	
	/**
	 * 查找所有的已审核通过的申购信息
	 * @return List<PassPor>
	 */
	public List<PassPor> findAllPassPor();
	
	/**
	 * 查找对应用户的审核通过的申购记录
	 * @param userId
	 * @return List
	 */
	public List<PassPor> findPassPorByUserId(String userId);
	
	/**
	 * 添加新的审核通过的申购信息
	 * @param passPor
	 */
	public void addPassPor(PassPor passPor);
	
	/**
	 * 删除审核通过的申购信息
	 * @param passPor
	 */
	public void deletePassPor(PassPor passPor);
}
