package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.PassPorDao;
import com.techpark.cm.domain.PassPor;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.PassPorService;

public class PassPorServiceImpl implements PassPorService {

	private PassPorDao passPorDao;
	
	@Override
	public PassPor findPassPorById(int id) {
		try {
			return passPorDao.findPassPorById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "�������ͨ���깺��Ϣʧ�ܣ�");
		}
	}

	@Override
	public List<PassPor> findAllPassPor() {
		try {
			return passPorDao.findAllPassPor();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ���������ͨ�����깺��Ϣʧ�ܣ�");
		}
	}

	@Override
	public void addPassPor(PassPor passPor) {
		try {
			passPorDao.addPassPor(passPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ͬ���깺ʧ�ܣ�");
		}
	}

	@Override
	public void deletePassPor(PassPor passPor) {
		try {
			passPorDao.deletePassPor(passPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ����ͨ����˵��깺��Ϣʧ�ܣ�");
		}
	}

	public void setPassPorDao(PassPorDao passPorDao) {
		this.passPorDao = passPorDao;
	}

	@Override
	public List<PassPor> findPassPorByUserId(String userId) {
		try {
			return passPorDao.findPassPorByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("��ѯ�û����ͨ�����깺��¼ʧ�ܣ�");
		}
	}

}
