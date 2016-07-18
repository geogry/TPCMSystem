package com.techpark.cm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.techpark.cm.dao.PostDao;
import com.techpark.cm.domain.Post;

public class PostDaoImpl extends HibernateDaoSupport implements PostDao {

	@Override
	public Post findPostById(int id) {
		return (Post) getHibernateTemplate().load(Post.class, id);
	}

	@Override
	public List<Post> findAllPost() {
		return getHibernateTemplate().find("from Post");
	}

	@Override
	public void addPost(Post post) {
		getHibernateTemplate().save(post);
	}

	@Override
	public void deletePost(Post post) {
		getHibernateTemplate().delete(post);
	}

}
