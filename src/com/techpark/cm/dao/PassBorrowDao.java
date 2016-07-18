package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.PassBorrow;

/**
 * ��ͨ����������Ϣ��Ĳ���
 * @author GJ
 *
 */
public interface PassBorrowDao {

	/**
	 * ����id������ͨ���Ľ�����Ϣ
	 * @param id
	 * @return PassBorrow
	 */
	public PassBorrow findPassBorrowById(int id);
	
	/**
	 * ��ȡ�������ͨ���Ľ�����Ϣ
	 * @return List<PassBorrow>
	 */
	public List<PassBorrow> findAllPassBorrow();
	
	/**
	 * ���Ҷ�Ӧ�û����ͨ���������¼
	 * @param userId
	 * @return List
	 */
	public List<PassBorrow> findPassBorrowByUserId(String userId);
	
	/**
	 * ������ͨ���Ľ�����Ϣ
	 * @param passBorrow
	 */
	public void addPassBorrow(PassBorrow passBorrow);
	
	/**
	 * �޸���ͨ����������Ϣ
	 * @param passBorrow
	 */
	public void modifyPassBorrow(PassBorrow passBorrow);
	
	/**
	 * ɾ����ͨ���Ľ�����Ϣ
	 * @param passBorrow
	 */
	public void deletePassBorrow(PassBorrow passBorrow);
}
