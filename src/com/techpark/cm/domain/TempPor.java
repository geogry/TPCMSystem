package com.techpark.cm.domain;

public class TempPor {

	//���
	private int id;
	
	//�깺����
	private TempElement tempElement;
	
	//������
	private User applicant;
	
	//����ʱ��
	private String time;
	
	//���ڸ�Ԫ����������Ϣ
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
