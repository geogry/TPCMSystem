package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.RefuseBorrow;

/**
 * �ܾ������������
 * @author GJ
 *
 */
public interface RefuseBorrowService {

	/**
	 * ����id��ñ��ܾ�����������
	 * @param id
	 * @return RefuseBorrow
	 */
	public RefuseBorrow findRefuseBorrowById(int id);
	
	/**
	 * ������б��ܾ�����������
	 * @return List
	 */
	public List<RefuseBorrow> findAllRefuseBorrow();
	
	/**
	 * ��ѯ��Ӧ�û����ܾ�����������
	 * @param userId
	 * @return List
	 */
	public List<RefuseBorrow> findRefuseBorrowByUserId(String userId);
	
	/**
	 * ��Ӿܾ���������
	 * @param refuseBorrow
	 */
	public void addRefuseBorrow(RefuseBorrow refuseBorrow);
	
	/**
	 * ɾ���ܾ���������
	 * @param refuseBorrow
	 */
	public void deleteRefuseBorrow(RefuseBorrow refuseBorrow);
}
