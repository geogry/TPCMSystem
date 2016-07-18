package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Element;

/**
 * 器件信息服务
 * @author GJ
 *
 */
public interface ElementService {

	/**
	 * 根据id获取器件信息
	 * @param id
	 * @return Element
	 */
	public Element findElementById(String id);
	
	/**
	 * 获取所有器件信息
	 * @return List
	 */
	public List<Element> findAllElement();
	
	/**
	 * 添加器件
	 * @param element
	 */
	public void addElement(Element element);
	
	/**
	 * 删除器件
	 * @param element
	 */
	public void deleteElement(Element element);
	
	/**
	 * 修改器件
	 * @param element
	 */
	public void modifyElement(Element element);
}
