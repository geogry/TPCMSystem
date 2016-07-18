package com.techpark.cm.domain;

public class PassPor {

	//编号
	private int id;
	
	//申购器件
	private TempElement tempElement;
	
	//申请人
	private User applicant;
	
	//审核人
	private User verifier;
	
	//申购时间
	private String time;
	
	//申购器件的其它信息
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

	public User getVerifier() {
		return verifier;
	}

	public void setVerifier(User verifier) {
		this.verifier = verifier;
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
