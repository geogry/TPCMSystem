package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.TempElement;

/**
 * ����ʱ��������в���
 * @author GJ
 *
 */
public interface TempElementDao {

	/**
	 * ����id������ʱ������Ϣ
	 * @param id
	 * @return TempElement
	 */
	public TempElement findTempElementById(int id);
	
	/**
	 * ����������ʱ������Ϣ
	 * @return List<TempElement>
	 */
	public List<TempElement> findAllTempElement();
	
	/**
	 * �����ʱ������Ϣ
	 * @param tempElement
	 */
	public void addTempElement(TempElement tempElement);
	
	/**
	 * ɾ����ʱ������Ϣ
	 * @param tempElement
	 */
	public void deleteTempElement(TempElement tempElement);
	
	/**
	 * �޸���ʱ������Ϣ
	 * @param tempElement
	 */
	public void modifyTempElement(TempElement tempElement);
}
