package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Notice;

/**
 * �������
 * @author GJ
 *
 */
public interface NoticeService {

	/**
	 * ����id��ȡ����
	 * @param id
	 * @return Notice
	 */
	public Notice findNoticeById(String id);
	
	/**
	 * ��ȡ���й���
	 * @return List<Notice>
	 */
	public List<Notice> findAllNotice();
	
	/**
	 * ��ҳ��ѯ����
	 * @return List<Notice>
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
