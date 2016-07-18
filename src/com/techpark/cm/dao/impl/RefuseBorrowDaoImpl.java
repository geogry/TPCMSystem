package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.RefuseBorrowDao;
import com.techpark.cm.domain.RefuseBorrow;

public class RefuseBorrowDaoImpl extends HibernateDaoSupport implements
		RefuseBorrowDao {

	@Override
	public RefuseBorrow findRefuseBorrowById(int id) {
		return (RefuseBorrow) getHibernateTemplate().load(RefuseBorrow.class, id);
	}

	@Override
	public List<RefuseBorrow> findAllRefuseBorrow() {
		return getHibernateTemplate().find("from RefuseBorrow r join fetch r.element join fetch r.applicant join fetch r.verifier");
	}

	@Override
	public void addRefuseBorrow(RefuseBorrow refuseBorrow) {
		getHibernateTemplate().save(refuseBorrow);
	}

	@Override
	public void deleteRefuseBorrow(RefuseBorrow refuseBorrow) {
		getHibernateTemplate().delete(refuseBorrow);
	}

	@Override
	public List<RefuseBorrow> findRefuseBorrowByUserId(String userId) {
		return getHibernateTemplate().find("from RefuseBorrow r join fetch r.element join fetch r.applicant join fetch r.verifier where r.applicant.id='" + userId + "'");
	}

}
