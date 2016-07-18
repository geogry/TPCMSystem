package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.RefusePor;

/**
 * 拒绝申购请求服务
 * @author GJ
 *
 */
public interface RefusePorService {

	/**
	 * 根据id获得被拒绝的申购请求
	 * @param id
	 * @return RefusePor
	 */
	public RefusePor findRefusePorById(int id);
	
	/**
	 * 获得所有被拒绝的申购请求
	 * @return List
	 */
	public List<RefusePor> findAllRefusePor();
	
	/**
	 * 查询对应用户被拒绝的申购请求
	 * @param userId
	 * @return List
	 */
	public List<RefusePor> findRefusePorByUserId(String userId);
	
	/**
	 * 添加被拒绝的申购请求
	 * @param refusePor
	 */
	public void addRefusePor(RefusePor refusePor);
	
	/**
	 * 删除被拒绝的申购请求
	 * @param refusePor
	 */
	public void deleteRefusePor(RefusePor refusePor);
}
