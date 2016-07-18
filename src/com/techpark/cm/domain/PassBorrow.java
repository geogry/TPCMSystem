package com.techpark.cm.domain;

public class PassBorrow {

	//编号
	private int id;
	
	//申请器件
	private Element element;
	
	//申请人
	private User applicant;
	
	//审核人
	private User verifier;
	
	//申请数量
	private int count;
	
	//申请时间
	private String time;
	
	//如果是设备，是否已归还
	private int returned;
	
	//借用目的
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

	public User getVerifier() {
		return verifier;
	}

	public void setVerifier(User verifier) {
		this.verifier = verifier;
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

	public int getReturned() {
		return returned;
	}

	public void setReturned(int returned) {
		this.returned = returned;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
