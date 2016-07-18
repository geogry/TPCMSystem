package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.TempBorrowDao;
import com.techpark.cm.domain.TempBorrow;

public class TempBorrowDaoImpl extends HibernateDaoSupport implements
		TempBorrowDao {

	@Override
	public TempBorrow findTempBorrowById(int id) {
		return (TempBorrow) getHibernateTemplate().load(TempBorrow.class, id);
	}

	@Override
	public List<TempBorrow> findAllTempBorrow() {
		return getHibernateTemplate().find("from TempBorrow t join fetch t.applicant join fetch t.element");
	}

	@Override
	public void addTempBorrow(TempBorrow tempBorrow) {
		//获取Hibernate提供的模版类并调用save方法将当前申领记录保存到数据库中
		getHibernateTemplate().save(tempBorrow);
	}

	@Override
	public void deleteTempBorrow(TempBorrow tempBorrow) {
		getHibernateTemplate().delete(tempBorrow);
	}
}
