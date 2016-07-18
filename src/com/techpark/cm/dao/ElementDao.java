package com.techpark.cm.dao;

import java.util.List;

import com.techpark.cm.domain.Element;

/**
 * �������������ɾ�Ĳ�
 * @author GJ
 *
 */
public interface ElementDao {

	/**
	 * ����id��������
	 * @param id
	 * @return Element
	 */
	public Element findElementById(String id);
	
	/**
	 * ������������
	 * @return List<Element>
	 */
	public List<Element> findAllElement();
	
	/**
	 * �������
	 * @param element
	 */
	public void addElement(Element element);
	
	/**
	 * ɾ������
	 * @param element
	 */
	public void deleteElement(Element element);
	
	/**
	 * �޸�����
	 * @param element
	 */
	public void modifyElement(Element element);
}
