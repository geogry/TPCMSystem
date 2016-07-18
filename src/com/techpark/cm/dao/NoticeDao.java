package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Notice;

/**
 * 对公告表进行操作
 * @author GJ
 *
 */
public interface NoticeDao {

	/**
	 * 按照id查找公告
	 * @param id
	 * @return Notice
	 */
	public Notice findNoticeById(String id);
	
	/**
	 * 查找所有公告
	 * @return List<Notice>
	 */
	public List<Notice> findAllNotice();
	
	/**
	 * 分页查询公告
	 * @return List
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
