package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.TempBorrow;

/**
 * ����ʱ������Ϣ����в���
 * @author GJ
 *
 */
public interface TempBorrowDao {

	/**
	 * ����id������ʱ������Ϣ
	 * @param id
	 * @return TempBorrow
	 */
	public TempBorrow findTempBorrowById(int id);
	
	/**
	 * ����������ʱ������Ϣ
	 * @return List<TempBorrow>
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
