package com.techpark.cm.domain;

import java.util.Set;

public class Locker {

	//�������
	private String id;
	
	//��������ڵص�
	private String addr;
	
	//���������
	private int capacity;
	
	//�����ǰ��������
	private int nowcapacity;
	
	//������д��е�����
	private Set<Element> elements;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getNowcapacity() {
		return nowcapacity;
	}

	public void setNowcapacity(int nowcapacity) {
		this.nowcapacity = nowcapacity;
	}

	public Set<Element> getElements() {
		return elements;
	}

	public void setElements(Set<Element> elements) {
		this.elements = elements;
	}
}
