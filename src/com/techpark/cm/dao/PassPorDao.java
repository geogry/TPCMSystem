package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.PassPor;

/**
 * ����ͨ�����깺��Ϣ����в���
 * @author GJ
 *
 */
public interface PassPorDao {

	/**
	 * ����id������ͨ����˵��깺��Ϣ
	 * @param id
	 * @return PassPor
	 */
	public PassPor findPassPorById(int id);
	
	/**
	 * �������е������ͨ�����깺��Ϣ
	 * @return List<PassPor>
	 */
	public List<PassPor> findAllPassPor();
	
	/**
	 * ���Ҷ�Ӧ�û������ͨ�����깺��¼
	 * @param userId
	 * @return List
	 */
	public List<PassPor> findPassPorByUserId(String userId);
	
	/**
	 * ����µ����ͨ�����깺��Ϣ
	 * @param passPor
	 */
	public void addPassPor(PassPor passPor);
	
	/**
	 * ɾ�����ͨ�����깺��Ϣ
	 * @param passPor
	 */
	public void deletePassPor(PassPor passPor);
}
