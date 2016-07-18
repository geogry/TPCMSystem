package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.ElementDao;
import com.techpark.cm.domain.Element;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.ElementService;

public class ElementServiceImpl implements ElementService {

	private ElementDao elementDao;
	
	@Override
	public Element findElementById(String id) {
		try {
			return elementDao.findElementById(id);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "��������ʧ�ܣ�");
		}
	}

	@Override
	public List<Element> findAllElement() {
		try {
			return elementDao.findAllElement();
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("��ѯȫ������ʧ�ܣ�");
		}
	}

	@Override
	public void addElement(Element element) {
		try {
			elementDao.addElement(element);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("�������ʧ�ܣ�");
		}
	}

	@Override
	public void deleteElement(Element element) {
		try {
			elementDao.deleteElement(element);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + element.getId() + "��������ʧ�ܣ�");
		}
	}

	@Override
	public void modifyElement(Element element) {
		try {
			elementDao.modifyElement(element);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("�޸�ID=��" + element.getId() + "��������ʧ�ܣ�");
		}
	}

	public void setElementDao(ElementDao elementDao) {
		this.elementDao = elementDao;
	}

}
