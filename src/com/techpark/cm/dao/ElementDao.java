package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Element;

/**
 * 对器件表进行增删改查
 * @author GJ
 *
 */
public interface ElementDao {

	/**
	 * 按照id查找器件
	 * @param id
	 * @return Element
	 */
	public Element findElementById(String id);
	
	/**
	 * 查找所有器件
	 * @return List<Element>
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
