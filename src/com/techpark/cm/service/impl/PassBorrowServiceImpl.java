package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.PassBorrowDao;
import com.techpark.cm.domain.PassBorrow;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.PassBorrowService;

public class PassBorrowServiceImpl implements PassBorrowService {

	private PassBorrowDao passBorrowDao;
	
	@Override
	public PassBorrow findPassBorrowById(int id) {
		try {
			return passBorrowDao.findPassBorrowById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "��ͨ����˵Ľ�����Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<PassBorrow> findAllPassBorrow() {
		try {
			return passBorrowDao.findAllPassBorrow();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯȫ�����ͨ���Ľ�����Ϣʧ�ܣ�");
		}
	}

	@Override
	public void addPassBorrow(PassBorrow passBorrow) {
		try {
			passBorrowDao.addPassBorrow(passBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͬ���������ʧ�ܣ�");
		}
	}

	@Override
	public void deletePassBorrow(PassBorrow passBorrow) {
		try {
			passBorrowDao.deletePassBorrow(passBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��ͨ�������Ϣʧ�ܣ�");
		}
	}

	public void setPassBorrowDao(PassBorrowDao passBorrowDao) {
		this.passBorrowDao = passBorrowDao;
	}

	@Override
	public List<PassBorrow> findPassBorrowByUserId(String userId) {
		try {
			return passBorrowDao.findPassBorrowByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û����ͨ���������¼ʧ�ܣ�");
		}
	}

	@Override
	public void modifyPassBorrow(PassBorrow passBorrow) {
		try {
			passBorrowDao.modifyPassBorrow(passBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("�޸��û����ͨ���������¼ʧ�ܣ�");
		}
	}

}
