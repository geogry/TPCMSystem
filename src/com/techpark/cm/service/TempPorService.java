package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.TempPor;

/**
 * Ϊ��ʱ�깺��Ϣ�ṩ�ķ���
 * @author GJ
 *
 */
public interface TempPorService {

	/**
	 * ����id������ʱ�깺��Ϣ
	 * @param id
	 * @return TempPor
	 */
	public TempPor findTempPorById(int id);
	
	/**
	 * ����������ʱ�깺��Ϣ
	 * @return List
	 */
	public List<TempPor> findAllTempPor();
	
	/**
	 * �����ʱ�깺��Ϣ
	 * @param tempPor
	 */
	public void addTempPor(TempPor tempPor);
	
	/**
	 * ɾ����ʱ�깺��Ϣ
	 * @param tempPor
	 */
	public void deleteTempPor(TempPor tempPor);
	
	/**
	 * �޸���ʱ�깺��Ϣ
	 * @param tempPor
	 */
	public void modifyTempPor(TempPor tempPor);
}
