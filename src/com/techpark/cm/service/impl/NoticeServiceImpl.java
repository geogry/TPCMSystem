package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.NoticeDao;
import com.techpark.cm.domain.Notice;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.NoticeService;

public class NoticeServiceImpl implements NoticeService {

	private NoticeDao noticeDao;
	
	@Override
	public Notice findNoticeById(String id) {
		try{
			return noticeDao.findNoticeById(id);
		}catch(Exception e){
			throw new AppException("查找id=【" + id +"】的公告失败！" );
		}
	}

	@Override
	public List<Notice> findAllNotice() {
		try{
			return noticeDao.findAllNotice();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查找所有公告失败！");
		}
	}
	
	@Override
	public List<Notice> findPageNotice(int start, int count) {
		try{
			return noticeDao.findPageNotice(start, count);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询公告失败！");
		}
	}

	@Override
	public void addNotice(Notice notice) {
		try{
			noticeDao.addNotice(notice);
		}catch(Exception e){
			throw new AppException("添加公告失败！");
		}
	}

	@Override
	public void deleteNotice(Notice notice) {
		try{
			noticeDao.deleteNotice(notice);
		}catch(Exception e){
			throw new AppException("删除id=【" + notice.getId() + "】的公告失败！");
		}
	}
	
	@Override
	public void deleteNoticeById(String id) {
		try{
			noticeDao.deleteNoticeById(id);
		}catch(Exception e){
			throw new AppException("删除id=【" + id + "】的公告失败");
		}
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
}
