package com.techpark.cm.domain;

public class PassBorrow {

	//���
	private int id;
	
	//��������
	private Element element;
	
	//������
	private User applicant;
	
	//�����
	private User verifier;
	
	//��������
	private int count;
	
	//����ʱ��
	private String time;
	
	//������豸���Ƿ��ѹ黹
	private int returned;
	
	//����Ŀ��
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
