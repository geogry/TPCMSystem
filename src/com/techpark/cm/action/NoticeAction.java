package com.techpark.cm.action;

import java.util.List;

import net.sf.json.JSONArray;

import com.opensymphony.xwork2.ActionSupport;
import com.techpark.cm.domain.Image;
import com.techpark.cm.domain.Notice;
import com.techpark.cm.service.ImageService;
import com.techpark.cm.service.NoticeService;
import com.techpark.cm.utils.DateUtil;

public class NoticeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService;
	
	private List<Notice> notices;
	
	private List<Image> images;
	
	private Notice notice;
	
	private String selectIds;
	
	private String jsonString;
	
	private ImageService imageService;

	@Override
	public String execute() throws Exception {
		notices = noticeService.findPageNotice(1, 11);
		images = imageService.findAllImage();
		return "success";
	}
	
	public String showNotices(){
		notices = noticeService.findAllNotice();
		JSONArray jsonArray = JSONArray.fromObject(notices);
		jsonString = "{success:true,totalCount:" + notices.size() + ",list:" + jsonArray.toString() + "}";
		return SUCCESS;
	}
	
	public String deleteNotice(){
		String[] ids = selectIds.split(",");
		for(int i = 0; i < ids.length; i++){
			notice = noticeService.findNoticeById(ids[i]);
			if(notice != null)
				noticeService.deleteNotice(notice);
		}
		jsonString = "{success:true}";
		return SUCCESS;
	}
	
	public String addNotice(){
		notice.setTime(DateUtil.dateFormat());
		noticeService.addNotice(notice);
		jsonString = "{success:true}";
		return SUCCESS;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setSelectIds(String selectIds) {
		this.selectIds = selectIds;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public List<Image> getImages() {
		return images;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
}
