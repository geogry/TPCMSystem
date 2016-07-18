package com.techpark.cm.domain;

public class TempPor {

	//编号
	private int id;
	
	//申购器件
	private TempElement tempElement;
	
	//申请人
	private User applicant;
	
	//申请时间
	private String time;
	
	//关于该元件的其它信息
	private String info;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TempElement getTempElement() {
		return tempElement;
	}

	public void setTempElement(TempElement tempElement) {
		this.tempElement = tempElement;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
