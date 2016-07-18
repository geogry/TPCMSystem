package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.TempElementDao;
import com.techpark.cm.domain.TempElement;

public class TempElementDaoImpl extends HibernateDaoSupport implements
		TempElementDao {

	@Override
	public TempElement findTempElementById(int id) {
		return (TempElement) getHibernateTemplate().load(TempElement.class, id);
	}

	@Override
	public List<TempElement> findAllTempElement() {
		return getHibernateTemplate().find("from TempElement t join fetch t.Type");
	}

	@Override
	public void addTempElement(TempElement tempElement) {
		getHibernateTemplate().save(tempElement);
	}

	@Override
	public void deleteTempElement(TempElement tempElement) {
		getHibernateTemplate().delete(tempElement);
	}

	@Override
	public void modifyTempElement(TempElement tempElement) {
		getHibernateTemplate().update(tempElement);
	}

}
