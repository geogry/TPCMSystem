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
			throw new AppException("��ѯID=��" + id + "������ʱ����ʧ�ܣ�");
		}
	}

	@Override
	public List<TempElement> findAllTempElement() {
		try {
			return tempElementDao.findAllTempElement();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ������ʱ����ʧ�ܣ�");
		}
	}

	@Override
	public void addTempElement(TempElement tempElement) {
		try {
			tempElementDao.addTempElement(tempElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�����ʱ����ʧ�ܣ�");
		}
	}

	@Override
	public void deleteTempElement(TempElement tempElement) {
		try {
			tempElementDao.deleteTempElement(tempElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + tempElement.getId() + "������ʱ����ʧ�ܣ�");
		}
	}

	@Override
	public void modifyTempElement(TempElement tempElement) {
		try {
			tempElementDao.modifyTempElement(tempElement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�޸�ID=��" + tempElement.getId() + "������ʱ����ʧ�ܣ�");
		}
	}

	public void setTempElementDao(TempElementDao tempElementDao) {
		this.tempElementDao = tempElementDao;
	}

}
