package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.TempBorrowDao;
import com.techpark.cm.domain.TempBorrow;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.TempBorrowService;

public class TempBorrowServiceImpl implements TempBorrowService {

	private TempBorrowDao tempBorrowDao;
	
	@Override
	public TempBorrow findTempBorrowById(int id) {
		try{
			return tempBorrowDao.findTempBorrowById(id);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯid=��" + id + "������ʱ�����¼ʧ�ܣ�");
		}
	}

	@Override
	public List<TempBorrow> findAllTempBorrow() {
		try{
			return tempBorrowDao.findAllTempBorrow();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯ������ʱ�����¼ʧ�ܣ�");
		}
	}

	@Override
	public void addTempBorrow(TempBorrow tempBorrow) {
		try{
			tempBorrowDao.addTempBorrow(tempBorrow);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("���id=��" + tempBorrow.getId() + "������ʱ�����¼ʧ�ܣ�");
		}
	}

	@Override
	public void deleteTempBorrow(TempBorrow tempBorrow) {
		try {
			tempBorrowDao.deleteTempBorrow(tempBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("ɾ��id=��" + tempBorrow.getId() + "������ʱ�����¼ʧ�ܣ�");
		}
	}

	public void setTempBorrowDao(TempBorrowDao tempBorrowDao) {
		this.tempBorrowDao = tempBorrowDao;
	}

}
