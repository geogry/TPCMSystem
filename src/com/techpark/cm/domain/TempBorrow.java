package com.techpark.cm.domain;

public class TempBorrow {

	//编号
	private int id;
	
	//借用的元件
	private Element element;
	
	//申请用户
	private User applicant;
	
	//数量
	private int count;
	
	//申请时间
	private String time;
	
	//器件通途
	private String purpose;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public User getApplicant() {
		return applicant;
	}

	public void setApplicant(User applicant) {
		this.applicant = applicant;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
