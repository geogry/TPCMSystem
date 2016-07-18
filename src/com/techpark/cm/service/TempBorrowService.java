package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.TempBorrow;

/**
 * ��ʱ���÷���
 * @author GJ
 *
 */
public interface TempBorrowService {

	/**
	 * ����id�����ʱ������Ϣ
	 * @param id
	 * @return TempBorrow
	 */
	public TempBorrow findTempBorrowById(int id);
	
	/**
	 * ���������ʱ������Ϣ
	 * @return List
	 */
	public List<TempBorrow> findAllTempBorrow();
	
	/**
	 * �����ʱ������Ϣ
	 * @param tempBorrow
	 */
	public void addTempBorrow(TempBorrow tempBorrow);
	
	/**
	 * ɾ����ʱ������Ϣ
	 * @param tempBorrow
	 */
	public void deleteTempBorrow(TempBorrow tempBorrow);
}
