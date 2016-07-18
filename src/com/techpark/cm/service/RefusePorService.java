package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.RefusePor;

/**
 * �ܾ��깺�������
 * @author GJ
 *
 */
public interface RefusePorService {

	/**
	 * ����id��ñ��ܾ����깺����
	 * @param id
	 * @return RefusePor
	 */
	public RefusePor findRefusePorById(int id);
	
	/**
	 * ������б��ܾ����깺����
	 * @return List
	 */
	public List<RefusePor> findAllRefusePor();
	
	/**
	 * ��ѯ��Ӧ�û����ܾ����깺����
	 * @param userId
	 * @return List
	 */
	public List<RefusePor> findRefusePorByUserId(String userId);
	
	/**
	 * ��ӱ��ܾ����깺����
	 * @param refusePor
	 */
	public void addRefusePor(RefusePor refusePor);
	
	/**
	 * ɾ�����ܾ����깺����
	 * @param refusePor
	 */
	public void deleteRefusePor(RefusePor refusePor);
}
