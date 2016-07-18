package com.techpark.cm.domain;

import java.util.Set;

public class Type {

	//���ͺ�
	private String id;
	
	//��������
	private String typename;
	
	//�Ƿ�Ϊ�Ĳ�
	private int iselement;
	
	//�������������Ԫ��
	private Set<Element> elements;
	
	//���������������ʱԪ��
	private Set<TempElement> tempElements;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public int getIselement() {
		return iselement;
	}

	public void setIselement(int iselement) {
		this.iselement = iselement;
	}

	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}

	public Set<TempElement> getTempElements() {
		return tempElements;
	}

	public void setTempElements(Set<TempElement> tempElements) {
		this.tempElements = tempElements;
	}
}
