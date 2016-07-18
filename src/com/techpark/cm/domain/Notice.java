package com.techpark.cm.domain;

public class Notice {

	//编号
	private String id;
	
	//公告内容
	private String content;
	
	//时间
	private String time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
