package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.TempElementDao;
import com.techpark.cm.domain.TempElement;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.TempElementService;

public class TempElementServiceImpl implements TempElementService {

	private TempElementDao tempElementDao;
	
	@Override
	public TempElement findTempElementById(int id) {
		try {
			return tempElementDao.findTempElementById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询ID=【" + id + "】的临时器件失败！");
		}
	}

	@Override
	public List<TempElement> findAllTempElement() {
		try {
			return tempElementDao.findAllTempElement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询所有临时器件失败！");
		}
	}

	@Override
	public void addTempElement(TempElement tempElement) {
		try {
			tempElementDao.addTempElement(tempElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("添加临时器件失败！");
		}
	}

	@Override
	public void deleteTempElement(TempElement tempElement) {
		try {
			tempElementDao.deleteTempElement(tempElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除ID=【" + tempElement.getId() + "】的临时器件失败！");
		}
	}

	@Override
	public void modifyTempElement(TempElement tempElement) {
		try {
			tempElementDao.modifyTempElement(tempElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("修改ID=【" + tempElement.getId() + "】的临时器件失败！");
		}
	}

	public void setTempElementDao(TempElementDao tempElementDao) {
		this.tempElementDao = tempElementDao;
	}

}
