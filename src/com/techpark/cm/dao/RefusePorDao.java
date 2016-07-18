package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.RefusePor;

/**
 * 对拒绝的申购信息表进行操作
 * @author GJ
 *
 */
public interface RefusePorDao {

	/**
	 * 根据id查找被拒绝的申购信息
	 * @param id
	 * @return RefusePor
	 */
	public RefusePor findRefusePorById(int id);
	
	/**
	 * 查找所有被拒绝的申购信息
	 * @return RefusePor
	 */
	public List<RefusePor> findAllRefusePor();
	
	/**
	 * 查找对应用户的拒绝申购记录
	 * @param userId
	 * @return List
	 */
	public List<RefusePor> findRefusePorByUserId(String userId);
	
	/**
	 * 添加被拒绝的申购信息
	 * @param refusePor
	 */
	public void addRefusePor(RefusePor refusePor);
	
	/**
	 * 删除被拒绝的申购信息
	 * @param refusePor
	 */
	public void deleteRefusePor(RefusePor refusePor);
}
