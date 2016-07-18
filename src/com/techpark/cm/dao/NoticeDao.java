package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Notice;

/**
 * �Թ������в���
 * @author GJ
 *
 */
public interface NoticeDao {

	/**
	 * ����id���ҹ���
	 * @param id
	 * @return Notice
	 */
	public Notice findNoticeById(String id);
	
	/**
	 * �������й���
	 * @return List<Notice>
	 */
	public List<Notice> findAllNotice();
	
	/**
	 * ��ҳ��ѯ����
	 * @return List
	 */
	public List<Notice> findPageNotice(int start, int count);
	
	/**
	 * ��ӹ���
	 * @param notice
	 */
	public void addNotice(Notice notice);
	
	/**
	 * ɾ������
	 * @param notice
	 */
	public void deleteNotice(Notice notice);
	
	/**
	 * ����idɾ������
	 * @param notice
	 */
	public void deleteNoticeById(String id);
}
