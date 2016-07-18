package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Post;

/**
 * 职务信息服务
 * @author GJ
 *
 */
public interface PostService {

	/**
	 * 根据id获取职务信息
	 * @param id
	 * @return Post
	 */
	public Post findPostById(int id);
	
	/**
	 * 获取所有职务信息
	 * @return List<Post>
	 */
	public List<Post> findAllPost();
	
	/**
	 * 添加职务
	 * @param post
	 */
	public void addPost(Post post);
	
	/**
	 * 删除职务
	 * @param post
	 */
	public void deltePost(Post post);
}
