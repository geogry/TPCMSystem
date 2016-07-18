package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.RefuseBorrow;

/**
 * �Ծܾ���������Ϣ����в���
 * @author GJ
 *
 */
public interface RefuseBorrowDao {

	/**
	 * ����id���Ҿܾ��Ľ�����Ϣ
	 * @param id
	 * @return RefuseBorrow
	 */
	public RefuseBorrow findRefuseBorrowById(int id);
	
	/**
	 * �������еľܾ��Ľ�����Ϣ
	 * @return List<RefuseBorrow>
	 */
	public List<RefuseBorrow> findAllRefuseBorrow();
	
	/**
	 * ���Ҷ�Ӧ�û��ľܾ�����
	 * @param id
	 * @return List
	 */
	public List<RefuseBorrow> findRefuseBorrowByUserId(String userId);
	
	/**
	 * ��Ӿܾ��Ľ�����Ϣ
	 * @param refuseBorrow
	 */
	public void addRefuseBorrow(RefuseBorrow refuseBorrow);
	
	/**
	 * ɾ���ܾ��Ľ�����Ϣ
	 * @param refuseBorrow
	 */
	public void deleteRefuseBorrow(RefuseBorrow refuseBorrow);
}
