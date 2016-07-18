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
			throw new AppException("查询ID=【" + id + "】通过审核的借用信息失败！");
		}
	}

	@Override
	public List<PassBorrow> findAllPassBorrow() {
		try {
			return passBorrowDao.findAllPassBorrow();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("查询全部审核通过的借用信息失败！");
		}
	}

	@Override
	public void addPassBorrow(PassBorrow passBorrow) {
		try {
			passBorrowDao.addPassBorrow(passBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("同意借用器件失败！");
		}
	}

	@Override
	public void deletePassBorrow(PassBorrow passBorrow) {
		try {
			passBorrowDao.deletePassBorrow(passBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("删除通过审核信息失败！");
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
			throw new AppException("查询用户审核通过的申领记录失败！");
		}
	}

	@Override
	public void modifyPassBorrow(PassBorrow passBorrow) {
		try {
			passBorrowDao.modifyPassBorrow(passBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("修改用户审核通过的申领记录失败！");
		}
	}

}
