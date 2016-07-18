package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.TypeDao;
import com.techpark.cm.domain.Type;

public class TypeDaoImpl extends HibernateDaoSupport implements TypeDao {

	@Override
	public Type findTypeById(String id) {
		return (Type) getHibernateTemplate().load(Type.class, id);
	}

	@Override
	public List<Type> findAllType() {
		return getHibernateTemplate().find("from Type");
	}

	@Override
	public void addType(Type type) {
		getHibernateTemplate().save(type);
	}

	@Override
	public void deleteType(Type type) {
		getHibernateTemplate().delete(type);
	}

	@Override
	public void modifyType(Type type) {
		getHibernateTemplate().update(type);
	}

}
