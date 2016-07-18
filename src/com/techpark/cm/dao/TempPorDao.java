package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.TempPor;

/**
 * ����ʱ�깺��Ϣ����в���
 * @author GJ
 *
 */
public interface TempPorDao {

	/**
	 * ����id������ʱ�깺��Ϣ
	 * @param id
	 * @return TempPor
	 */
	public TempPor findTempPorById(int id);
	
	/**
	 * ����������ʱ�깺��Ϣ
	 * @return List<TempPor>
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
