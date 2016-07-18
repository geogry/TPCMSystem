package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.TempPorDao;
import com.techpark.cm.domain.TempPor;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.TempPorService;

public class TempPorServiceImpl implements TempPorService {

	private TempPorDao tempPorDao;
	
	@Override
	public TempPor findTempPorById(int id) {
		try {
			return tempPorDao.findTempPorById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ID=¡¾" + id + "¡¿µÄÉê¹ºÐÅÏ¢Ê§°Ü£¡");
		}
	}

	@Override
	public List<TempPor> findAllTempPor() {
		try {
			return tempPorDao.findAllTempPor();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ËùÓÐµÄÉê¹ºÉêÇë£¡");
		}
	}

	@Override
	public void addTempPor(TempPor tempPor) {
		try {
			tempPorDao.addTempPor(tempPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("±£´æÉê¹ºÐÅÏ¢Ê§°Ü£¡");
		}
	}

	@Override
	public void deleteTempPor(TempPor tempPor) {
		try {
			tempPorDao.deleteTempPor(tempPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("É¾³ýID=¡¾"+ tempPor.getId() + "¡¿µÄÉê¹ºÐÅÏ¢Ê§°Ü£¡");
		}
	}

	@Override
	public void modifyTempPor(TempPor tempPor) {
		try {
			tempPorDao.modifyTempPor(tempPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ÐÞ¸ÄID=¡¾" + tempPor.getId() + "¡¿µÄÉê¹ºÐÅÏ¢Ê§°Ü£¡");
		}
	}

	public void setTempPorDao(TempPorDao tempPorDao) {
		this.tempPorDao = tempPorDao;
	}

}
