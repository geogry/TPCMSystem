package com.techpark.cm.service.impl;

import java.util.List;

import com.techpark.cm.dao.PostDao;
import com.techpark.cm.domain.Post;
import com.techpark.cm.exception.AppException;
import com.techpark.cm.service.PostService;

public class PostServiceImpl implements PostService {

	private PostDao postDao;
	
	@Override
	public Post findPostById(int id) {
		try{
			return postDao.findPostById(id);
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯID=��" + id + "����ְλʧ�ܣ�");
		}
	}

	@Override
	public List<Post> findAllPost() {
		try{
			return postDao.findAllPost();
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("��ѯ����ְλʧ�ܣ�");
		}
	}

	@Override
	public void addPost(Post post) {
		try{
			postDao.addPost(post);
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("�������=��" + post.getPostname() + "����ְ��ʧ�ܣ�");
		}
	}

	@Override
	public void deltePost(Post post) {
		try{
			postDao.deletePost(post);
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("ɾ��ID=��" + post.getId() + "����ְ��ʧ�ܣ�");
		}
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

}
