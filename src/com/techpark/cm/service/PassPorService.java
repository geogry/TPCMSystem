package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.PassPor;

/**
 * ���ͨ�����깺��Ϣ����
 * @author GJ
 *
 */
public interface PassPorService {

	/**
	 * ����id������ͨ�����깺����
	 * @param id
	 * @return PassPor
	 */
	public PassPor findPassPorById(int id);
	
	/**
	 * ����������ͨ�����깺����
	 * @return List
	 */
	public List<PassPor> findAllPassPor();
	
	/**
	 * ��ѯ��Ӧ�û����ͨ�����깺����
	 * @param userId
	 * @return List
	 */
	public List<PassPor> findPassPorByUserId(String userId);
	
	/**
	 * ����깺����
	 * @param passPor
	 */
	public void addPassPor(PassPor passPor);
	
	/**
	 * ɾ���깺����
	 * @param passPor
	 */
	public void deletePassPor(PassPor passPor);
}
