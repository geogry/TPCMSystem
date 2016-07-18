package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.TempPorDao;
import com.techpark.cm.domain.TempPor;

public class TempPorDaoImpl extends HibernateDaoSupport implements TempPorDao {

	@Override
	public TempPor findTempPorById(int id) {
		return (TempPor) getHibernateTemplate().load(TempPor.class, id);
	}

	@Override
	public List<TempPor> findAllTempPor() {
		return getHibernateTemplate().find("from TempPor t join fetch t.applicant join fetch t.tempElement");
	}

	@Override
	public void addTempPor(TempPor tempPor) {
		getHibernateTemplate().save(tempPor);
	}

	@Override
	public void deleteTempPor(TempPor tempPor) {
		getHibernateTemplate().delete(tempPor);
	}

	@Override
	public void modifyTempPor(TempPor tempPor) {
		getHibernateTemplate().update(tempPor);
	}

}
