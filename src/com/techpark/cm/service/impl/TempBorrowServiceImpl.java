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
			throw new AppException("²éÑ¯id=¡¾" + id + "¡¿µÄÁÙÊ±ÉêÁì¼ÇÂ¼Ê§°Ü£¡");
		}
	}

	@Override
	public List<TempBorrow> findAllTempBorrow() {
		try{
			return tempBorrowDao.findAllTempBorrow();
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("²éÑ¯ËùÓÐÁÙÊ±ÉêÁì¼ÇÂ¼Ê§°Ü£¡");
		}
	}

	@Override
	public void addTempBorrow(TempBorrow tempBorrow) {
		try{
			tempBorrowDao.addTempBorrow(tempBorrow);
		}catch(Exception e){
			e.printStackTrace();
			throw new AppException("Ìí¼Óid=¡¾" + tempBorrow.getId() + "¡¿µÄÁÙÊ±ÉêÁì¼ÇÂ¼Ê§°Ü£¡");
		}
	}

	@Override
	public void deleteTempBorrow(TempBorrow tempBorrow) {
		try {
			tempBorrowDao.deleteTempBorrow(tempBorrow);
		} catch (Exception e) {
			e.printStackTrace();
			throw new AppException("É¾³ýid=¡¾" + tempBorrow.getId() + "¡¿µÄÁÙÊ±ÉêÁì¼ÇÂ¼Ê§°Ü£¡");
		}
	}

	public void setTempBorrowDao(TempBorrowDao tempBorrowDao) {
		this.tempBorrowDao = tempBorrowDao;
	}

}
