package com.techpark.cm.domain;

import java.util.Set;

public class Locker {

	//储物柜编号
	private String id;
	
	//储物柜所在地点
	private String addr;
	
	//储物柜容量
	private int capacity;
	
	//储物柜当前器件种数
	private int nowcapacity;
	
	//储物柜中存有的器件
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
