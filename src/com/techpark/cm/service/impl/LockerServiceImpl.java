package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.LockerDao;
import com.techpark.cm.domain.Locker;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.LockerService;

public class LockerServiceImpl implements LockerService {

	private LockerDao lockerDao;
	
	@Override
	public Locker findLockerById(String id) {
		try{
			return lockerDao.findLockerById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("²éÑ¯ID=¡¾" + id + "¡¿µÄ´¢Îï¹ñÊ§°Ü£¡");
		}
	}

	@Override
	public List<Locker> findAllLocker() {
		try {
			return lockerDao.findAllLocker();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯È«²¿µÄ´¢Îï¹ñÊ§°Ü£¡");
		}
	}

	@Override
	public void addLocker(Locker locker) {
		try {
			lockerDao.addLocker(locker);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("Ìí¼ÓÐÂµÄ´¢Îï¹ñÊ§°Ü£¡");
		}
	}

	@Override
	public void deleteLocker(Locker locker) {
		try {
			lockerDao.deleteLocker(locker);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("É¾³ýID=¡¾" + locker.getId() + "¡¿µÄ´¢Îï¹ñÊ§°Ü£¡");
		}
	}

	@Override
	public void modifyLocker(Locker locker) {
		try {
			lockerDao.modifyLocker(locker);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ÐÞ¸ÄID=¡¾" + locker.getId() + "¡¿µÄ´¢Îï¹ñÊ§°Ü£¡");
		}
	}

	public void setLockerDao(LockerDao lockerDao) {
		this.lockerDao = lockerDao;
	}

}
