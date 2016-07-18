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
			throw new AppException("²éÑ¯ID=¡¾" + id + "¡¿µÄÉóºËÍ¨¹ýÉê¹ºÐÅÏ¢Ê§°Ü£¡");
		}
	}

	@Override
	public List<PassPor> findAllPassPor() {
		try {
			return passPorDao.findAllPassPor();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ËùÓÐÒÑÉóºËÍ¨¹ýµÄÉê¹ºÐÅÏ¢Ê§°Ü£¡");
		}
	}

	@Override
	public void addPassPor(PassPor passPor) {
		try {
			passPorDao.addPassPor(passPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("Í¬ÒâÉê¹ºÊ§°Ü£¡");
		}
	}

	@Override
	public void deletePassPor(PassPor passPor) {
		try {
			passPorDao.deletePassPor(passPor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("É¾³ýÒÑÍ¨¹ýÉóºËµÄÉê¹ºÐÅÏ¢Ê§°Ü£¡");
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
			throw new AppException("²éÑ¯ÓÃ»§ÉóºËÍ¨¹ýµÄÉê¹º¼ÇÂ¼Ê§°Ü£¡");
		}
	}

}
