package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.RefuseBorrowDao;
import com.techpark.cm.domain.RefuseBorrow;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.RefuseBorrowService;

public class RefuseBorrowServiceImpl implements RefuseBorrowService {

	private RefuseBorrowDao refuseBorrowDao;
	
	@Override
	public RefuseBorrow findRefuseBorrowById(int id) {
		try {
			return refuseBorrowDao.findRefuseBorrowById(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ID=¡¾" + id + "¡¿µÄ¾Ü¾øÉêÇëÊ§°Ü£¡");
		}
	}

	@Override
	public List<RefuseBorrow> findAllRefuseBorrow() {
		try {
			return refuseBorrowDao.findAllRefuseBorrow();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ËùÓÐµÄ¾Ü¾øÉêÇëÊ§°Ü£¡");
		}
	}

	@Override
	public void addRefuseBorrow(RefuseBorrow refuseBorrow) {
		try {
			refuseBorrowDao.addRefuseBorrow(refuseBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("¾Ü¾ø¸ÃÉêÇëÊ§°Ü£¡");
		}
	}

	@Override
	public void deleteRefuseBorrow(RefuseBorrow refuseBorrow) {
		try {
			refuseBorrowDao.deleteRefuseBorrow(refuseBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("É¾³ýID=¡¾" + refuseBorrow.getId() + "¡¿µÄ¾Ü¾øÉêÇëÊ§°Ü£¡");
		}
	}

	public void setRefuseBorrowDao(RefuseBorrowDao refuseBorrowDao) {
		this.refuseBorrowDao = refuseBorrowDao;
	}

	@Override
	public List<RefuseBorrow> findRefuseBorrowByUserId(String userId) {
		try {
			return refuseBorrowDao.findRefuseBorrowByUserId(userId);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("²éÑ¯ÓÃ»§±»¾Ü¾øµÄÉêÁì¼ÇÂ¼Ê§°Ü£¡");
		}
	}

}
