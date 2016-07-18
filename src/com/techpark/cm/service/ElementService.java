package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Element;

/**
 * ������Ϣ����
 * @author GJ
 *
 */
public interface ElementService {

	/**
	 * ����id��ȡ������Ϣ
	 * @param id
	 * @return Element
	 */
	public Element findElementById(String id);
	
	/**
	 * ��ȡ����������Ϣ
	 * @return List
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
