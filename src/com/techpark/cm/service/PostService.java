package com.techpark.cm.service;

import java.util.List;

import com.techpark.cm.domain.Post;

/**
 * ְ����Ϣ����
 * @author GJ
 *
 */
public interface PostService {

	/**
	 * ����id��ȡְ����Ϣ
	 * @param id
	 * @return Post
	 */
	public Post findPostById(int id);
	
	/**
	 * ��ȡ����ְ����Ϣ
	 * @return List<Post>
	 */
	public List<Post> findAllPost();
	
	/**
	 * ���ְ��
	 * @param post
	 */
	public void addPost(Post post);
	
	/**
	 * ɾ��ְ��
	 * @param post
	 */
	public void deltePost(Post post);
}
