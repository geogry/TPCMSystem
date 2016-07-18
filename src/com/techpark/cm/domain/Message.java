package com.techpark.cm.domain;

public class Message {

	//编号
	private String id;
	
	//发送时间
	private String time;
	
	//消息内容
	private String content;
	
	//用户
	private User user;
	
	//是否已查看
	private int checked;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getChecked() {
		return checked;
	}

	public void setChecked(int checked) {
		this.checked = checked;
	}
}
