package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.PassBorrow;

/**
 * ���ͨ����������Ϣ����
 * @author GJ
 *
 */
public interface PassBorrowService {

	/**
	 * ����id��ȡͨ����˵�������Ϣ
	 * @param id
	 * @return PassBorrow
	 */
	public PassBorrow findPassBorrowById(int id);
	
	/**
	 * ��ȡ�������ͨ����������Ϣ
	 * @return List
	 */
	public List<PassBorrow> findAllPassBorrow();
	
	/**
	 * ���Ҷ�Ӧ�û�����ͨ������
	 * @param userId
	 * @return List
	 */
	public List<PassBorrow> findPassBorrowByUserId(String userId);
	
	/**
	 * ������ͨ����������Ϣ
	 * @param passBorrow
	 */
	public void addPassBorrow(PassBorrow passBorrow);
	
	/**
	 * �޸���ͨ��������Ϣ
	 * @param passBorrow
	 */
	public void modifyPassBorrow(PassBorrow passBorrow);
	
	/**
	 * ɾ�����ͨ����������Ϣ
	 * @param passBorrow
	 */
	public void deletePassBorrow(PassBorrow passBorrow);
}
