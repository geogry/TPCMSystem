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
			throw new AppException("查询ID=【" + id + "】的审核通过申购信息失败！");
		}
	}

	@Override
	public List<PassPor> findAllPassPor() {
		try {
			return passPorDao.findAllPassPor();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询所有已审核通过的申购信息失败！");
		}
	}

	@Override
	public void addPassPor(PassPor passPor) {
		try {
			passPorDao.addPassPor(passPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("同意申购失败！");
		}
	}

	@Override
	public void deletePassPor(PassPor passPor) {
		try {
			passPorDao.deletePassPor(passPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除已通过审核的申购信息失败！");
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
			throw new AppException("查询用户审核通过的申购记录失败！");
		}
	}

}
