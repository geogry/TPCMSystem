package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.RefusePor;

/**
 * �Ծܾ����깺��Ϣ����в���
 * @author GJ
 *
 */
public interface RefusePorDao {

	/**
	 * ����id���ұ��ܾ����깺��Ϣ
	 * @param id
	 * @return RefusePor
	 */
	public RefusePor findRefusePorById(int id);
	
	/**
	 * �������б��ܾ����깺��Ϣ
	 * @return RefusePor
	 */
	public List<RefusePor> findAllRefusePor();
	
	/**
	 * ���Ҷ�Ӧ�û��ľܾ��깺��¼
	 * @param userId
	 * @return List
	 */
	public List<RefusePor> findRefusePorByUserId(String userId);
	
	/**
	 * ��ӱ��ܾ����깺��Ϣ
	 * @param refusePor
	 */
	public void addRefusePor(RefusePor refusePor);
	
	/**
	 * ɾ�����ܾ����깺��Ϣ
	 * @param refusePor
	 */
	public void deleteRefusePor(RefusePor refusePor);
}
