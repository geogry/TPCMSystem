package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Notice;

/**
 * 公告服务
 * @author GJ
 *
 */
public interface NoticeService {

	/**
	 * 根据id获取公告
	 * @param id
	 * @return Notice
	 */
	public Notice findNoticeById(String id);
	
	/**
	 * 获取所有公告
	 * @return List<Notice>
	 */
	public List<Notice> findAllNotice();
	
	/**
	 * 分页查询公告
	 * @return List<Notice>
	 */
	public List<Notice> findPageNotice(int start, int count);
	
	/**
	 * 添加公告
	 * @param notice
	 */
	public void addNotice(Notice notice);
	
	/**
	 * 删除公告
	 * @param notice
	 */
	public void deleteNotice(Notice notice);
	
	/**
	 * 根据id删除公告
	 * @param notice
	 */
	public void deleteNoticeById(String id);
}
