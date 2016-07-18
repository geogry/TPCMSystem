package com.techpark.cm.domain;

public class Element {

	//器件编号
	private String id;
	
	//器件名称
	private String elementname;
	
	//封装类型
	private String feature;
	
	//库存量
	private int store;
	
	//存储仓库
	private Locker locker;
	
	//器件类型
	private Type type;
	
	//图片
	private String img;
	
	//手册
	private String manual;

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public Locker getLocker() {
		return locker;
	}

	public void setLocker(Locker locker) {
		this.locker = locker;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
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

	public int getStore() {
		return store;
	}

	public void setStore(int store) {
		this.store = store;
	}
}
