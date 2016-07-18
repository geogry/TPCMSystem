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
			throw new AppException("��ѯID=��" + id + "���Ĵ����ʧ�ܣ�");
		}
	}

	@Override
	public List<Locker> findAllLocker() {
		try {
			return lockerDao.findAllLocker();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯȫ���Ĵ����ʧ�ܣ�");
		}
	}

	@Override
	public void addLocker(Locker locker) {
		try {
			lockerDao.addLocker(locker);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����µĴ����ʧ�ܣ�");
		}
	}

	@Override
	public void deleteLocker(Locker locker) {
		try {
			lockerDao.deleteLocker(locker);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + locker.getId() + "���Ĵ����ʧ�ܣ�");
		}
	}

	@Override
	public void modifyLocker(Locker locker) {
		try {
			lockerDao.modifyLocker(locker);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�޸�ID=��" + locker.getId() + "���Ĵ����ʧ�ܣ�");
		}
	}

	public void setLockerDao(LockerDao lockerDao) {
		this.lockerDao = lockerDao;
	}

}
