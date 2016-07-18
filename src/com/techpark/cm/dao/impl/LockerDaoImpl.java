package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.LockerDao;
import com.techpark.cm.domain.Locker;

public class LockerDaoImpl extends HibernateDaoSupport implements LockerDao {

	@Override
	public Locker findLockerById(String id) {
		return (Locker) getHibernateTemplate().load(Locker.class, id);
	}

	@Override
	public List<Locker> findAllLocker() {
		return getHibernateTemplate().find("from Locker");
	}

	@Override
	public void addLocker(Locker locker) {
		getHibernateTemplate().save(locker);
	}

	@Override
	public void deleteLocker(Locker locker) {
		getHibernateTemplate().delete(locker);
	}

	@Override
	public void modifyLocker(Locker locker) {
		getHibernateTemplate().update(locker);
	}

}
