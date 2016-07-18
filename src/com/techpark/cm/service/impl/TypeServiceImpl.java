package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.TypeDao;
import com.techpark.cm.domain.Type;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.TypeService;

public class TypeServiceImpl implements TypeService {

	private TypeDao typeDao;
	
	@Override
	public Type findTypeById(String id) {
		try {
			return typeDao.findTypeById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "�����豸����ʧ�ܣ�");
		}
	}

	@Override
	public List<Type> findAllType() {
		try {
			return typeDao.findAllType();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�����豸����ʧ�ܣ�");
		}
	}

	@Override
	public void addType(Type type) {
		try {
			typeDao.addType(type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("����豸����ʧ�ܣ�");
		}
	}

	@Override
	public void deleteType(Type type) {
		try {
			typeDao.deleteType(type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + type.getId() + "�����豸����ʧ�ܣ�");
		}
	}

	@Override
	public void modifyType(Type type) {
		try {
			typeDao.modifyType(type);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�޸�ID=��" + type.getId() + "�����豸����ʧ�ܣ�");
		}
	}

	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}

}
