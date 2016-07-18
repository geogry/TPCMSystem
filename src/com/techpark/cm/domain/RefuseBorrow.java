package com.techpark.cm.domain;

public class RefuseBorrow {

	//编号
	private int id;
	
	//借用器件
	private Element element;
	
	//申请人
	private User applicant;
	
	//审核人
	private User verifier;
	
	//借用数量
	private int count;
	
	//申请时间
	private String time;
	
	//拒绝理由
	private String reason;
	
	//申请目的
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
}
