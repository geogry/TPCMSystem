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
			throw new AppException("查询ID=【" + id + "】的职位失败！");
		}
	}

	@Override
	public List<Post> findAllPost() {
		try{
			return postDao.findAllPost();
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("查询所有职位失败！");
		}
	}

	@Override
	public void addPost(Post post) {
		try{
			postDao.addPost(post);
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("添加名称=【" + post.getPostname() + "】的职务失败！");
		}
	}

	@Override
	public void deltePost(Post post) {
		try{
			postDao.deletePost(post);
		} catch(Exception e){
			e.printStackTrace();
			throw new AppException("删除ID=【" + post.getId() + "】的职务失败！");
		}
	}

	public void setPostDao(PostDao postDao) {
		this.postDao = postDao;
	}

}
