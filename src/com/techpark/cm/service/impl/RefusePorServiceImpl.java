package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.RefusePorDao;
import com.techpark.cm.domain.RefusePor;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.RefusePorService;

public class RefusePorServiceImpl implements RefusePorService {

	private RefusePorDao refusePorDao;
	
	@Override
	public RefusePor findRefusePorById(int id) {
		try {
			return refusePorDao.findRefusePorById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ID=¡¾" + id + "¡¿µÄ¾Ü¾øÉê¹ºÊ§°Ü£¡");
		}
	}

	@Override
	public List<RefusePor> findAllRefusePor() {
		try {
			return refusePorDao.findAllRefusePor();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ËùÓÐµÄ¾Ü¾øÉê¹ºÊ§°Ü£¡");
		}
	}

	@Override
	public void addRefusePor(RefusePor refusePor) {
		try {
			refusePorDao.addRefusePor(refusePor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("¾Ü¾ø¸ÃÉêÇëÊ§°Ü£¡");
		}
	}

	@Override
	public void deleteRefusePor(RefusePor refusePor) {
		try {
			refusePorDao.deleteRefusePor(refusePor);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("É¾³ýID=¡¾" + refusePor.getId() + "¡¿µÄ¾Ü¾øÉê¹ºÊ§°Ü£¡");
		}
	}

	public void setRefusePorDao(RefusePorDao refusePorDao) {
		this.refusePorDao = refusePorDao;
	}

	@Override
	public List<RefusePor> findRefusePorByUserId(String userId) {
		try {
			return refusePorDao.findRefusePorByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ÓÃ»§±»¾Ü¾øµÄÉê¹º¼ÇÂ¼Ê§°Ü£¡");
		}
	}

}
