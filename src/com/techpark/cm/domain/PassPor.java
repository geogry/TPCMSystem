package com.techpark.cm.domain;

public class PassPor {

	//���
	private int id;
	
	//�깺����
	private TempElement tempElement;
	
	//������
	private User applicant;
	
	//�����
	private User verifier;
	
	//�깺ʱ��
	private String time;
	
	//�깺������������Ϣ
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
