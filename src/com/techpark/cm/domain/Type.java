package com.techpark.cm.domain;

import java.util.Set;

public class Type {

	//类型号
	private String id;
	
	//类型名称
	private String typename;
	
	//是否为耗材
	private int iselement;
	
	//该类包含的所有元件
	private Set<Element> elements;
	
	//该类包含的所有临时元件
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
