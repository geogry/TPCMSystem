package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.RefusePorDao;
import com.techpark.cm.domain.RefusePor;

public class RefusePorDaoImpl extends HibernateDaoSupport implements
		RefusePorDao {

	@Override
	public RefusePor findRefusePorById(int id) {
		return (RefusePor) getHibernateTemplate().load(RefusePor.class, id);
	}

	@Override
	public List<RefusePor> findAllRefusePor() {
		return getHibernateTemplate().find("from RefusePor r join fetch r.tempElement join fetch r.applicant join fetch r.verifier");
	}

	@Override
	public void addRefusePor(RefusePor refusePor) {
		getHibernateTemplate().save(refusePor);
	}

	@Override
	public void deleteRefusePor(RefusePor refusePor) {
		getHibernateTemplate().delete(refusePor);
	}

	@Override
	public List<RefusePor> findRefusePorByUserId(String userId) {
		return getHibernateTemplate().find("from RefusePor r join fetch r.tempElement join fetch r.applicant join fetch r.verifier where r.applicant.id='" + userId + "'");
	}

}
