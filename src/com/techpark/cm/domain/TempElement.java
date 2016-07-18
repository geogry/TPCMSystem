package com.techpark.cm.domain;

public class TempElement {

	//编号
	private int id;
	
	//器件名称
	private String elementname;
	
	//封装类型
	private String feature;
	
	//类型
	private Type type;
	
	//数量
	private int count;
	
	//单价
	private int price;
	
	//图片
	private String img;
	
	//手册
	private String manual;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElementname() {
		return elementname;
	}

	public void setElementname(String elementname) {
		this.elementname = elementname;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getManual() {
		return manual;
	}

	public void setManual(String manual) {
		this.manual = manual;
	}
}
