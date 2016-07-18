package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.ImageDao;
import com.techpark.cm.domain.Image;

public class ImageDaoImpl extends HibernateDaoSupport implements ImageDao {

	@Override
	public void modify(Image image) {
		getHibernateTemplate().update(image);
	}

	@Override
	public Image findImageById(int id) {
		return (Image) getHibernateTemplate().find("from Image i where id=" + id).get(0);
	}

	@Override
	public List<Image> findAllImage() {
		return getHibernateTemplate().find("from Image");
	}

}
