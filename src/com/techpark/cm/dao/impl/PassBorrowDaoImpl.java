package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.PassBorrowDao;
import com.techpark.cm.domain.PassBorrow;

public class PassBorrowDaoImpl extends HibernateDaoSupport implements
		PassBorrowDao {

	@Override
	public PassBorrow findPassBorrowById(int id) {
		return (PassBorrow) getHibernateTemplate().load(PassBorrow.class, id);
	}

	@Override
	public List<PassBorrow> findAllPassBorrow() {
		return getHibernateTemplate().find("from PassBorrow p join fetch p.element join fetch p.applicant join fetch p.verifier");
	}

	@Override
	public void addPassBorrow(PassBorrow passBorrow) {
		getHibernateTemplate().save(passBorrow);
	}

	@Override
	public void deletePassBorrow(PassBorrow passBorrow) {
		getHibernateTemplate().delete(passBorrow);
	}

	@Override
	public List<PassBorrow> findPassBorrowByUserId(String userId) {
		return getHibernateTemplate().find("from PassBorrow p join fetch p.element join fetch p.applicant join fetch p.verifier where p.applicant.id='" + userId + "'");
	}

	@Override
	public void modifyPassBorrow(PassBorrow passBorrow) {
		getHibernateTemplate().update(passBorrow);
	}

}
