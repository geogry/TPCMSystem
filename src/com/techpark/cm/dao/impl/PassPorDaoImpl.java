package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.PassPorDao;
import com.techpark.cm.domain.PassPor;

public class PassPorDaoImpl extends HibernateDaoSupport implements PassPorDao {

	@Override
	public PassPor findPassPorById(int id) {
		return (PassPor) getHibernateTemplate().load(PassPor.class, id);
	}

	@Override
	public List<PassPor> findAllPassPor() {
		return getHibernateTemplate().find("from PassPor p join fetch p.tempElement join fetch p.applicant join fetch p.verifier");
	}

	@Override
	public void addPassPor(PassPor passPor) {
		getHibernateTemplate().save(passPor);
	}

	@Override
	public void deletePassPor(PassPor passPor) {
		getHibernateTemplate().delete(passPor);
	}

	@Override
	public List<PassPor> findPassPorByUserId(String userId) {
		return getHibernateTemplate().find("from PassPor p join fetch p.tempElement join fetch p.applicant join fetch p.verifier where p.applicant.id='" + userId + "'");
	}

}
