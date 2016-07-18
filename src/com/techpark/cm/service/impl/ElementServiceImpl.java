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
			throw new AppException("查询ID=【" + id + "】的器件失败！");
		}
	}

	@Override
	public List<Element> findAllElement() {
		try {
			return elementDao.findAllElement();
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("查询全部器件失败！");
		}
	}

	@Override
	public void addElement(Element element) {
		try {
			elementDao.addElement(element);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("添加器件失败！");
		}
	}

	@Override
	public void deleteElement(Element element) {
		try {
			elementDao.deleteElement(element);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("删除ID=【" + element.getId() + "】的器件失败！");
		}
	}

	@Override
	public void modifyElement(Element element) {
		try {
			elementDao.modifyElement(element);
		} catch (Exception e){
			e.printStackTrace();
			throw new AppException("修改ID=【" + element.getId() + "】的器件失败！");
		}
	}

	public void setElementDao(ElementDao elementDao) {
		this.elementDao = elementDao;
	}

}
