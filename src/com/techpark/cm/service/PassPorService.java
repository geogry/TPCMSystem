package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.PassPor;

/**
 * 审核通过的申购信息服务
 * @author GJ
 *
 */
public interface PassPorService {

	/**
	 * 根据id获得审核通过的申购请求
	 * @param id
	 * @return PassPor
	 */
	public PassPor findPassPorById(int id);
	
	/**
	 * 获得所有审核通过的申购请求
	 * @return List
	 */
	public List<PassPor> findAllPassPor();
	
	/**
	 * 查询对应用户审核通过的申购申请
	 * @param userId
	 * @return List
	 */
	public List<PassPor> findPassPorByUserId(String userId);
	
	/**
	 * 添加申购请求
	 * @param passPor
	 */
	public void addPassPor(PassPor passPor);
	
	/**
	 * 删除申购请求
	 * @param passPor
	 */
	public void deletePassPor(PassPor passPor);
}
