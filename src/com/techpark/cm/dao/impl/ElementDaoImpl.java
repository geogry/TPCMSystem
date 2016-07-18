package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.ElementDao;
import com.techpark.cm.domain.Element;

public class ElementDaoImpl extends HibernateDaoSupport implements ElementDao {

	@Override
	public Element findElementById(String id) {
		return (Element) getHibernateTemplate().get(Element.class, id);
	}

	@Override
	public List<Element> findAllElement() {
		return getHibernateTemplate().find("from Element e join fetch e.type join fetch e.locker");
	}

	@Override
	public void addElement(Element element) {
		getHibernateTemplate().save(element);
	}

	@Override
	public void deleteElement(Element element) {
		getHibernateTemplate().delete(element);
	}

	@Override
	public void modifyElement(Element element) {
		getHibernateTemplate().update(element);
	}

}
